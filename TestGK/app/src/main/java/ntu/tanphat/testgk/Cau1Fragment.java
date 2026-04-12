package ntu.tanphat.testgk;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Cau1Fragment extends Fragment {
    EditText editTextSo1;
    EditText editTextSo2;
    EditText editTextKQ;
    Button nutCong, nutTru, nutNhan, nutChia;
    void TimDieuKhien(View view){
        editTextSo1 = view.findViewById(R.id.edtSo1);
        editTextSo2 = view.findViewById(R.id.edtSo2);
        editTextKQ = view.findViewById(R.id.edtKq);
        nutCong = view.findViewById(R.id.btnCong);
        nutTru = view.findViewById(R.id.btnTru);
        nutNhan = view.findViewById(R.id.btnNhan);
        nutChia = view.findViewById(R.id.btnChia);
    }
    public Cau1Fragment() {


    }
    public static Cau1Fragment newInstance(String param1, String param2) {
        Cau1Fragment fragment = new Cau1Fragment();
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
        View view = inflater.inflate(R.layout.fragment_cau1, container, false);
        TimDieuKhien(view);
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
        return view;
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