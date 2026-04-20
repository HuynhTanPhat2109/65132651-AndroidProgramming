package thigk2.huynhtanphat.baithigk2;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Cau2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Cau2Fragment extends Fragment {
    ArrayList<String> DsCaKhuc = new ArrayList<String>();
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
        //Hiển thị dữ liệu lên ListView
        //B1: Cần có dữ liệu
        DsCaKhuc.add("Nơi này của anh Huỳnh Tấn Phát");
        DsCaKhuc.add("Bạc phận");
        DsCaKhuc.add("Lời của gió");
        DsCaKhuc.add("Sóng gió");
        DsCaKhuc.add("Đom đóm");
        DsCaKhuc.add("Lạc trôi");
        DsCaKhuc.add("Lạc trôi");
        DsCaKhuc.add("Lạc trôi");
        DsCaKhuc.add("Lạc trôi");
        DsCaKhuc.add("Lạc trôi");

        //B2: Tạo Adapter
        ArrayAdapter<String> adapterMonAn = new ArrayAdapter<String>(view.getContext(),
                R.layout.item_cakhuc,
                R.id.txtTen,
                DsCaKhuc);
        //B3: Gắn vào điều khiển hiển thị
        ListView listViewDSCaKhuc = view.findViewById(R.id.lvDSCaKhuc);
        listViewDSCaKhuc.setAdapter(adapterMonAn);
        listViewDSCaKhuc.setOnItemClickListener(BoLangNghevaXL);
        return view;
    }
    AdapterView.OnItemClickListener BoLangNghevaXL = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String strTenCaKhuc = DsCaKhuc.get(position);
//            Intent intent = new Intent(getContext(), ChiTietMonActivity.class);
//            intent.putExtra("tenMon", strTenMonAn);
//            startActivity(intent);
            Toast.makeText(getContext(),strTenCaKhuc,Toast.LENGTH_LONG).show();
        }
    };
}