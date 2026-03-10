package com.example.baith4_linearlayout_tong2so;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    //Khai báo các đối tượng gắn với điều khiển tương ứng ở đây
    EditText editTextSo1;
    EditText editTextSo2;
    EditText editTextKQ;
    Button nutCong,nutTru,nutNhan,nutChia;
    void TimDieuKhien(){
        editTextSo1 = (EditText)findViewById(R.id.edtSo1);
        editTextSo2 = (EditText)findViewById(R.id.edtSo2);
        editTextKQ = (EditText)findViewById(R.id.edtKetQua);
        nutCong = (Button)findViewById(R.id.btnCong);
        nutTru = (Button)findViewById(R.id.btnTru);
        nutNhan = (Button)findViewById(R.id.btnNhan);
        nutChia = (Button)findViewById(R.id.btnChia);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TimDieuKhien();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    //Xử lý cộng
    public void XuLyCong(View v){
        //b1. Lấy dữ liệu 2 số
        //b1.1. Tìm EditText số 1 và 2
        //b1.2. Lấy dự liệu từ 2 điều khiển
        String soThu1 = editTextSo1.getText().toString();
        String soThu2 = editTextSo2.getText().toString();
        //b1.3. Chuyển dữ liệu từ chuỗi sang số
        float soA = Float.parseFloat(soThu1);
        float soB = Float.parseFloat(soThu2);
        //Tính toán
        float tong = soA + soB;
        //b3.Hiện kết quả
        String edtKQ = String.valueOf(tong);
        editTextKQ.setText(edtKQ);
    }
    public void XuLyTru(View v){
        String SoThu1 = editTextSo1.getText().toString();
        String SoThu2 = editTextSo2.getText().toString();
        float soA = Float.parseFloat(SoThu1);
        float soB = Float.parseFloat(SoThu2);
        float hieu = soA - soB;
        String edtKQ = String.valueOf(hieu);
        editTextKQ.setText(edtKQ);
    }
    public void XuLyNhan(View v){
        String SoThu1 = editTextSo1.getText().toString();
        String SoThu2 = editTextSo2.getText().toString();
        float soA = Float.parseFloat(SoThu1);
        float soB = Float.parseFloat(SoThu2);
        float Thuong = soA * soB;
        String edtKQ = String.valueOf(Thuong);
        editTextKQ.setText(edtKQ);
    }
    public void XuLyChia(View v){
        String SoThu1 = editTextSo1.getText().toString();
        String SoThu2 = editTextSo2.getText().toString();
        float soA = Float.parseFloat(SoThu1);
        float soB = Float.parseFloat(SoThu2);
        float Chia = soA / soB;
        String edtKQ = String.valueOf(Chia);
        editTextKQ.setText(edtKQ);
    }
}