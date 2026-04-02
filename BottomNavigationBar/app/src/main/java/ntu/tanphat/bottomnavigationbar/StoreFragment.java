package ntu.tanphat.bottomnavigationbar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class StoreFragment extends Fragment {
    public StoreFragment() {
        // Required empty public constructor
    }
    public static StoreFragment newInstance(String param1, String param2) {
        StoreFragment fragment = new StoreFragment();
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
        View view = inflater.inflate(R.layout.fragment_store, container, false);

        //Tìm listView
        ListView lvDSMonAn = view.findViewById(R.id.lvDSMonAn);

        //Chuẩn bị nguồn dữ liệu
        ArrayList<MonAn> dsMonAn = new ArrayList<MonAn>();
        dsMonAn.add(new MonAn("Cơm tấm sườn", 25000, "Cơm tấm sườn đậm vị, ngon và hấp dẫn", R.drawable.cts));
        dsMonAn.add(new MonAn("Cơm tấm sườn trứng", 30000, "Món ăn có hương vị đậm đà và là best seller của quán", R.drawable.ctst));
        dsMonAn.add(new MonAn("Cơm tấm sườn bì chả", 35000, "Bì, chả làm nên sự khác biệt của hương vị món ăn", R.drawable.sbc));
        dsMonAn.add(new MonAn("Cơm gà", 25000, "Cơm gà đậm vị, thịt gà rất ngọt", R.drawable.cg));
        dsMonAn.add(new MonAn("Bún thịt nướng", 20000, "Bún thịt nướng là thịt được nướng vàng đều, có vị đậm đà cùng hương thơm của sả và vừng; nước mắm chua ngọt vừa ăn; và các loại rau dùng kèm đa dạng.", R.drawable.btn));

        //
        MonAnAdapter adapter = new MonAnAdapter(view.getContext(), dsMonAn);
        lvDSMonAn.setAdapter(adapter);

        //Bắt và xử lý sự kiện
        lvDSMonAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Lấy phần tử được chọn
                MonAn monAnChon = dsMonAn.get(position);
                Toast.makeText(view.getContext(), monAnChon.getTenMonAn(), Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}