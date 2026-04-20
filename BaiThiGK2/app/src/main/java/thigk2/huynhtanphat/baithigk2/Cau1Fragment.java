package thigk2.huynhtanphat.baithigk2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Locale;

public class Cau1Fragment extends Fragment {

    EditText edtTien, edtTiGia;
    Button btnDoi;
    TextView tvKetQua;

    public Cau1Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Gắn layout vào fragment
        View view = inflater.inflate(R.layout.fragment_cau1, container, false);

        // 2. Ánh xạ (tìm ID)
        edtTien = view.findViewById(R.id.edtTien);
        edtTiGia = view.findViewById(R.id.edtTiGia);
        btnDoi = view.findViewById(R.id.btnDoi);
        tvKetQua = view.findViewById(R.id.tvKetQua);

        // 3. Xử lý khi bấm nút
        btnDoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lấy chữ trong ô nhập ra
                String sTien = edtTien.getText().toString();
                String sGia = edtTiGia.getText().toString();

                // Chuyển chữ thành số để tính toán
                double vVND = Double.parseDouble(sTien);
                double vGia = Double.parseDouble(sGia);

                // Tính toán
                double vUSD = vVND / vGia;

                // Hiển thị lên màn hình
                tvKetQua.setText("Kết quả: " + vUSD + " USD");
            }
        });

        return view;
    }
}