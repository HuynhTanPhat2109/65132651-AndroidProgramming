package ntu.tanphat.testgk;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Cau4Fragment extends Fragment {
    EditText editTextWeight, editTextHeight;
    Button cal_BMI;
    TextView textViewBMI, textViewLoai;
    void TimDieuKhien(View view){
        editTextWeight = view.findViewById(R.id.edtWeight);
        editTextHeight = view.findViewById(R.id.edtHeight);
        cal_BMI = view.findViewById(R.id.btnTinhBMI);
        textViewBMI = view.findViewById(R.id.tvBMI);
        textViewLoai = view.findViewById(R.id.tvLoai);
    }
    public Cau4Fragment() {
        // Required empty public constructor
    }
    public static Cau4Fragment newInstance(String param1, String param2) {
        Cau4Fragment fragment = new Cau4Fragment();
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
        View view = inflater.inflate(R.layout.fragment_cau4, container, false);
        TimDieuKhien(view);
        cal_BMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TinhBMI();
            }
        });
        return view;
    }
    void TinhBMI(){
        String weight = editTextWeight.getText().toString();
        String height = editTextHeight.getText().toString();
        float canNang = Float.parseFloat(weight);
        float chieuCao = Float.parseFloat(height);
        chieuCao = chieuCao / 100;
        float BMI = canNang / (chieuCao * chieuCao);
        String ketquaBMI = String.valueOf(BMI);
        textViewBMI.setText(ketquaBMI);
        if(BMI < 18.5)
            textViewLoai.setText("Gầy");
        else if (BMI >= 18.5 && BMI <= 24.9)
            textViewLoai.setText("Bình thường");
        else
            textViewLoai.setText("Thừa cân");
    }
}