package ntu.tanphat.baith6_xulysukien_bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText editTextWeight, editTextHeight;
    Button cal_BMI;
    TextView textViewBMI, textViewLoai;
    void TimDieuKhien(){
        editTextWeight = (EditText) findViewById(R.id.edtWeight);
        editTextHeight = (EditText) findViewById(R.id.edtHeight);
        cal_BMI = (Button) findViewById(R.id.btnTinhBMI);
        textViewBMI = (TextView) findViewById(R.id.tvBMI);
        textViewLoai = (TextView) findViewById(R.id.tvLoai);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TimDieuKhien();
        cal_BMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TinhBMI();
            }
        });
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