package thigk2.huynhtanphat.baithigk2;

import android.os.Bundle;
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

    private EditText edtAmount, edtRate;
    private Button btnConvert;
    private TextView tvResult;

    public Cau1Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Gắn layout vào fragment
        View view = inflater.inflate(R.layout.fragment_cau1, container, false);

        // Ánh xạ các thành phần giao diện
        edtAmount = view.findViewById(R.id.edtAmount);
        edtRate = view.findViewById(R.id.edtRate);
        btnConvert = view.findViewById(R.id.btnConvert);
        tvResult = view.findViewById(R.id.tvResult);

        // Thiết lập sự kiện click cho nút chuyển đổi
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertCurrency();
            }
        });

        return view;
    }

    private void convertCurrency() {
        String strAmount = edtAmount.getText().toString();
        String strRate = edtRate.getText().toString();

        // Kiểm tra xem người dùng đã nhập đủ thông tin chưa
        if (strAmount.isEmpty() || strRate.isEmpty()) {
            Toast.makeText(getContext(), "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double amount = Double.parseDouble(strAmount);
            double rate = Double.parseDouble(strRate);

            if (rate <= 0) {
                Toast.makeText(getContext(), "Tỷ giá phải lớn hơn 0", Toast.LENGTH_SHORT).show();
                return;
            }

            // Tính toán số tiền đô la
            double usd = amount / rate;

            // Hiển thị kết quả (định dạng 2 chữ số thập phân)
            tvResult.setText(String.format(Locale.getDefault(), "Kết quả: %.2f USD", usd));

        } catch (NumberFormatException e) {
            Toast.makeText(getContext(), "Vui lòng nhập số hợp lệ", Toast.LENGTH_SHORT).show();
        }
    }
}