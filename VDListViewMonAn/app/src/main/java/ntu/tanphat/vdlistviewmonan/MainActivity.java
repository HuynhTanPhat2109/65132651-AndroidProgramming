package ntu.tanphat.vdlistviewmonan;

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
    ArrayList<String> DSMonAn = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        DSMonAn.add("Bún bò huế");
        DSMonAn.add("Phở Nam");
        DSMonAn.add("Bún thịt nướng");
        DSMonAn.add("Bánh cuốn");
        DSMonAn.add("Bún đậu mắm tôm");
        DSMonAn.add("Cơm tấm");

        ArrayAdapter<String> adapterMonAn = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, DSMonAn);

        ListView listViewMA = (ListView)findViewById(R.id.lvMonAn);
        listViewMA.setAdapter(adapterMonAn);
        listViewMA.setOnItemClickListener(BoLangNgheVaXL);


    }
    AdapterView.OnItemClickListener BoLangNgheVaXL = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String tenMonAnChon = DSMonAn.get(position);
            Toast.makeText(MainActivity.this, tenMonAnChon, Toast.LENGTH_LONG).show();
        }
    };
}