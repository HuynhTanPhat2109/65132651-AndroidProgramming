package com.example.apptinhtong;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    //Đây là bộ lắng nghe và xử lý sự kiện click lên nút tính tổng
    public void XuLyCong(View view){

        //Tìm, tham chiếu đến các điều khiển trên tệp XML
        EditText editTextSoA = findViewById(R.id.edtA);
        EditText editTextSoB = findViewById(R.id.edtB);
        EditText editTextKQ = findViewById(R.id.edtKQ);

        //Lấy dữ liệu về
        String strA = editTextSoA.getText().toString();
        String strB = editTextSoB.getText().toString();

        //Chuyển dữ liệu sang dạng số
        int SoA = Integer.parseInt(strA);
        int SoB = Integer.parseInt(strB);

        //Tính tổng
        int tong = SoA + SoB;
        String strTong = String.valueOf(tong);
        //Hiện ra màn hình
        editTextKQ.setText(strTong);
    }
}