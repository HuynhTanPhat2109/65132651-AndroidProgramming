package ntu.tanphat.docbaorss;

import android.os.Bundle;
import android.widget.BaseAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<BaiBaoItem> list = new ArrayList<>();
    BaiBaoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new BaiBaoAdapter(this, list);
        recyclerView.setAdapter(adapter);

        new Thread(() -> {
            List<BaiBaoItem> data = GetDataFromRSS.getRSS();

            runOnUiThread(() -> {
                list.addAll(data);
                adapter.notifyDataSetChanged();
            });
        }).start();
    }
}