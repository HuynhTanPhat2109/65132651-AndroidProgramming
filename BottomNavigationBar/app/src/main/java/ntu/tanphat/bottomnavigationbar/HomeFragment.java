package ntu.tanphat.bottomnavigationbar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class HomeFragment extends Fragment {
    EditText editTextWeight, editTextHeight;
    Button cal_BMI;
    TextView textViewBMI, textViewLoai;

    public HomeFragment() {
        // Required empty public constructor
    }
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        editTextWeight = view.findViewById(R.id.edtWeight);
        editTextHeight = view.findViewById(R.id.edtHeight);
        cal_BMI = view.findViewById(R.id.btnTinhBMI);
        textViewBMI = view.findViewById(R.id.tvBMI);
        textViewLoai = view.findViewById(R.id.tvLoai);

        cal_BMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        });
        return view;
    }
}