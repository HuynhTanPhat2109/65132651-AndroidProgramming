package ntu.tanphat.baith7_listview1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> DsTinhThanh = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Hiển thị dữ liệu lên ListView
        //B1: Cần có dữ liệu
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
        //Gắn bộ lắng nghe vào
        listViewDSTT.setOnItemClickListener(BoLangNghevaXL);
    }
    //Tạo bộ lắng nghe và xử lý sự kiện onItemClick, đặt vào một biến vd: BoLangNghevaXl
    AdapterView.OnItemClickListener BoLangNghevaXL = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String strTenTinhChon = DsTinhThanh.get(position);
            Toast.makeText(MainActivity.this,strTenTinhChon,Toast.LENGTH_LONG).show();
        }
    };
}