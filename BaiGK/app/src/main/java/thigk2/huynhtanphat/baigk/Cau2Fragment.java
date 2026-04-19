package thigk2.huynhtanphat.baigk;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Cau2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Cau2Fragment extends Fragment {
    ArrayList<String> DsMonAn = new ArrayList<String>();
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
        //Hiển thị dữ liệu lên ListView
        //B1: Cần có dữ liệu
        DsMonAn.add("Bún chả");
        DsMonAn.add("Cơm gà");
        DsMonAn.add("Phở nam");
        DsMonAn.add("Bún thịt nướng");
        DsMonAn.add("Bún đậu mắm tôm");
        DsMonAn.add("Cơm tấm");

        //B2: Tạo Adapter
        ArrayAdapter<String> adapterMonAn = new ArrayAdapter<String>(view.getContext(),
                R.layout.item_monan,
                R.id.txtTen,
                DsMonAn);
        //B3: Gắn vào điều khiển hiển thị
        ListView listViewDSMonAnn = view.findViewById(R.id.lvDSMonAn);
        listViewDSMonAnn.setAdapter(adapterMonAn);
        listViewDSMonAnn.setOnItemClickListener(BoLangNghevaXL);
        return view;
    }
    AdapterView.OnItemClickListener BoLangNghevaXL = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String strTenMonAn = DsMonAn.get(position);
            Intent intent = new Intent(getContext(), ChiTietMonActivity.class);
            intent.putExtra("tenMon", strTenMonAn);
            startActivity(intent);
//            String strTenMonAn = DsMonAn.get(position);
//            Toast.makeText(MainActivity.this,strTenMonAn,Toast.LENGTH_LONG).show();
        }
    };
}