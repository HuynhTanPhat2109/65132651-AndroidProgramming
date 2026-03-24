package ntu.tanphat.baith8_tuychinhlv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MonAnAdapter extends BaseAdapter {
    private ArrayList<MonAn> dsMonAn;
    private LayoutInflater layoutInflater;
    private Context context;

    public MonAnAdapter(Context _context, ArrayList<MonAn> dsMonAn) {
        this.dsMonAn = dsMonAn;
        this.context = _context;
        this.layoutInflater = LayoutInflater.from(_context);
    }

    @Override
    public int getCount() {
        return dsMonAn.size();
    }

    @Override
    public Object getItem(int position) {
        return dsMonAn.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //View item hiện hành
        View viewHienHanh = convertView;
        if(viewHienHanh == null)
            viewHienHanh = layoutInflater.inflate(R.layout.item_monan, null);
        //Lấy dữ liệu
        MonAn monAnHienTai = dsMonAn.get(position);
        //Gán lên các điều khiển


        //Tìm điều khiển
        TextView textViewTenMonAn = (TextView)viewHienHanh.findViewById(R.id.tvTenMonAn);
        TextView textViewDonGia = (TextView)viewHienHanh.findViewById(R.id.tvDonGia);
        TextView textViewMoTa = (TextView)viewHienHanh.findViewById(R.id.tvMoTa);
        ImageView imgViewAnh = (ImageView)viewHienHanh.findViewById(R.id.imgAnhDaiDien);
        //Set lên
        textViewTenMonAn.setText(monAnHienTai.getTenMonAn());
        textViewDonGia.setText(String.valueOf(monAnHienTai.getDonGia()));
        textViewMoTa.setText(monAnHienTai.getMoTa());
        imgViewAnh.setImageResource(monAnHienTai.getIdAnhMinhHoa());

        return viewHienHanh;
    }
}
