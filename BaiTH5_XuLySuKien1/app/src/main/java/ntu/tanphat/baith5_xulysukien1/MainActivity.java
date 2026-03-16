package ntu.tanphat.baith5_xulysukien1;

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
    EditText editTextSo1;
    EditText editTextSo2;
    EditText editTextKQ;
    Button nutCong, nutTru, nutNhan, nutChia;
    void TimDieuKhien(){
        editTextSo1 = (EditText)findViewById(R.id.edtSo1);
        editTextSo2 = (EditText)findViewById(R.id.edtSo2);
        editTextKQ = (EditText)findViewById(R.id.edtKq);
        nutCong = (Button)findViewById(R.id.btnCong);
        nutTru = (Button) findViewById(R.id.btnTru);
        nutNhan = (Button) findViewById(R.id.btnNhan);
        nutChia = (Button) findViewById(R.id.btnChia);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TimDieuKhien();

        nutCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XuLyCong();
            }
        });

        nutTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XuLyTru();
            }
        });

        nutNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XuLyNhan();
            }
        });

        nutChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XuLyChia();
            }
        });
    }

    void XuLyCong(){
        String soA = editTextSo1.getText().toString();
        String soB = editTextSo2.getText().toString();
        float soThu1 = Float.parseFloat(soA);
        float soThu2 = Float.parseFloat(soB);
        float tong = soThu1 + soThu2;
        String chuoiKQ = String.valueOf(tong);
        editTextKQ.setText(chuoiKQ);
    }
    void XuLyTru(){
        String soA = editTextSo1.getText().toString();
        String soB = editTextSo2.getText().toString();
        float soThu1 = Float.parseFloat(soA);
        float soThu2 = Float.parseFloat(soB);
        float hieu = soThu1 - soThu2;
        String chuoiKQ = String.valueOf(hieu);
        editTextKQ.setText(chuoiKQ);
    }
    void XuLyNhan(){
        String soA = editTextSo1.getText().toString();
        String soB = editTextSo2.getText().toString();
        float soThu1 = Float.parseFloat(soA);
        float soThu2 = Float.parseFloat(soB);
        float tich = soThu1 * soThu2;
        String chuoiKQ = String.valueOf(tich);
        editTextKQ.setText(chuoiKQ);
    }
    void XuLyChia(){
        String soA = editTextSo1.getText().toString();
        String soB = editTextSo2.getText().toString();
        float soThu1 = Float.parseFloat(soA);
        float soThu2 = Float.parseFloat(soB);
        float thuong = soThu1 / soThu2;
        String chuoiKQ = String.valueOf(thuong);
        editTextKQ.setText(chuoiKQ);
    }
}