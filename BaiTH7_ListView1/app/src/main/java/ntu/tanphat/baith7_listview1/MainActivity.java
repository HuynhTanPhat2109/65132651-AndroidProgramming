package ntu.tanphat.baith7_listview1;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Hiển thị dữ liệu lên ListView
        //B1: Cần có dữ liệu
        ArrayList<String> DsTinhThanh = new ArrayList<String>();
        DsTinhThanh.add("Hà Nội");
        DsTinhThanh.add("Tp. Hồ Chí Minh");
        DsTinhThanh.add("Đồng Nai");
        DsTinhThanh.add("Nha Trang");
        DsTinhThanh.add("Bình Thuận");
        DsTinhThanh.add("Ninh Thuận");

        //B2: Tạo Adapter
        ArrayAdapter<String> adapterTT = new ArrayAdapter<String>(this,
                                                                    android.R.layout.simple_list_item_1,
                                                                    DsTinhThanh);
        //B3: Gắn vào điều khiển hiển thị
        ListView listViewDSTT = (ListView)findViewById(R.id.lvDanhSachTT);
        listViewDSTT.setAdapter(adapterTT);
    }
}