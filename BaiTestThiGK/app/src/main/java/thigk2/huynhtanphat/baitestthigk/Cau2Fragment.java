package thigk2.huynhtanphat.baitestthigk;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Cau2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Cau2Fragment extends Fragment {
    ArrayList<String> DsMonAn = new ArrayList<String>();
    ArrayAdapter<String> adapterMonAn;

    public Cau2Fragment() {
        // Required empty public constructor
    }
    public static Cau2Fragment newInstance(String param1, String param2) {
        Cau2Fragment fragment = new Cau2Fragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cau2, container, false);

        // Khởi tạo Adapter với danh sách rỗng ban đầu
        adapterMonAn = new ArrayAdapter<String>(view.getContext(),
                R.layout.item_monan,
                R.id.txtTen,
                DsMonAn);

        // Gắn vào điều khiển hiển thị
        ListView listViewDSMonAnn = view.findViewById(R.id.lvDSMonAn);
        listViewDSMonAnn.setAdapter(adapterMonAn);
        listViewDSMonAnn.setOnItemClickListener(BoLangNghevaXL);

        // Load dữ liệu từ JSON (Giả lập nhận dữ liệu từ API hoặc File)
        loadDataFromJson();

        return view;
    }

    private void loadDataFromJson() {
        // Chuỗi JSON mẫu (Trong thực tế bạn có thể đọc từ assets hoặc gọi API qua thư viện như Volley/Retrofit)
        String jsonString = "[\"Bún chả\", \"Cơm gà\", \"Phở nam\", \"Bún thịt nướng\", \"Bún đậu mắm tôm\", \"Cơm tấm\"]";

        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            DsMonAn.clear();
            for (int i = 0; i < jsonArray.length(); i++) {
                DsMonAn.add(jsonArray.getString(i));
            }
            // Cập nhật lại giao diện sau khi danh sách thay đổi
            adapterMonAn.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    AdapterView.OnItemClickListener BoLangNghevaXL = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String strTenMonAn = DsMonAn.get(position);
            
            // Chuyển sang màn hình chi tiết món ăn
            Intent intent = new Intent(getContext(), ChiTietMonActivity.class);
            intent.putExtra("tenMon", strTenMonAn);
            startActivity(intent);
//            String strTenMonAn = DsMonAn.get(position);
//            Toast.makeText(MainActivity.this,strTenMonAn,Toast.LENGTH_LONG).show();
        }
    };
}
