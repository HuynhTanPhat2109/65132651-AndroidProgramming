package ntu.tanphat.docbaorss;

public class BaiBaoItem {
    String title;
    String link;
    String pubDate;
    String image;
    String description;

    public BaiBaoItem(String title, String link, String pubDate, String image, String description) {
        this.title = title;
        this.link = link;
        this.pubDate = pubDate;
        this.image = image;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getPubDate() {
        return pubDate;
    }

    public String getImage() {
        return image;
    }
}
