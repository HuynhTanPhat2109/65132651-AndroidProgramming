package ntu.tanphat.docbaorss;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GetDataFromRSS {

    public static List<BaiBaoItem> getRSS() {

        List<BaiBaoItem> list = new ArrayList<>();

        try {
            URL url = new URL("https://vnexpress.net/rss/giao-duc.rss");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.setConnectTimeout(10000);
            conn.setReadTimeout(10000);
            conn.connect();

            InputStream input = conn.getInputStream();

            XmlPullParser parser = Xml.newPullParser();
            parser.setInput(input, null);

            int eventType = parser.getEventType();

            String title = "", pubDate = "", imgUrl = "";
            boolean isInsideItem = false;
            String currentTag = "";

            while (eventType != XmlPullParser.END_DOCUMENT) {

                String name = parser.getName();

                switch (eventType) {

                    case XmlPullParser.START_TAG:
                        currentTag = name;

                        if ("item".equals(name)) {
                            isInsideItem = true;
                            title = "";
                            pubDate = "";
                            imgUrl = "";
                        }

                        if (isInsideItem) {
                            // 🔥 LẤY ẢNH TỪ ATTRIBUTE URL (QUAN TRỌNG NHẤT)
                            String attr = parser.getAttributeValue(null, "url");
                            if (attr != null && !attr.isEmpty()) {
                                imgUrl = attr;
                            }
                        }
                        break;

                    case XmlPullParser.TEXT:
                        if (isInsideItem) {
                            String text = parser.getText();

                            if (text != null && !text.trim().isEmpty()) {

                                if ("title".equals(currentTag)) {
                                    title = text.trim();
                                } else if ("pubDate".equals(currentTag)) {
                                    pubDate = text.trim();
                                } else if ("description".equals(currentTag)) {
                                    // nếu chưa có ảnh thì lấy từ description
                                    if (imgUrl.isEmpty()) {
                                        imgUrl = getImgFromDesc(text);
                                    }
                                }
                            }
                        }
                        break;

                    case XmlPullParser.END_TAG:
                        if ("item".equals(name)) {
                            list.add(new BaiBaoItem(title, "", pubDate, imgUrl, ""));
                            isInsideItem = false;
                        }
                        currentTag = "";
                        break;
                }

                eventType = parser.next();
            }

            input.close();
            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // 🔥 lấy ảnh từ description (backup)
    private static String getImgFromDesc(String desc) {
        try {
            int start = desc.indexOf("src=\"");
            if (start != -1) {
                start += 5;
                int end = desc.indexOf("\"", start);
                if (end != -1) {
                    return desc.substring(start, end);
                }
            }
        } catch (Exception e) {}
        return "";
    }
}