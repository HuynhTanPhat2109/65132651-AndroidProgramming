package ntu.tanphat.bonusloginandregister;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    EditText edtEmail, edtPass, edtConfirmPass;
    Button btnRegister;
    TextView tvToLog;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edtEmail = findViewById(R.id.edtRegisterEmail);
        edtPass = findViewById(R.id.edtRegisterPassword);
        edtConfirmPass = findViewById(R.id.edtRegisterConfirmPassword);
        btnRegister = findViewById(R.id.btnRegister);
        tvToLog = findViewById(R.id.tvToLogin);

        mAuth = FirebaseAuth.getInstance();

        // Chuyển sang trang đăng nhập nếu có tài khoản
        tvToLog.setOnClickListener(v -> {
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEmail.getText().toString().trim();
                String pass = edtPass.getText().toString().trim();
                String confirmPass = edtConfirmPass.getText().toString().trim();

                if(email.isEmpty() || pass.isEmpty() || confirmPass.isEmpty()){
                    Toast.makeText(v.getContext(), "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(pass.length() < 6){
                    Toast.makeText(v.getContext(), "Mật khẩu phải có ít nhất 6 ký tự", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!pass.equals(confirmPass)){
                    Toast.makeText(v.getContext(), "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                    return;
                }

                //Tạo tài khoản
                mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(RegisterActivity.this, task -> {
                    if(task.isSuccessful()){
                        Toast.makeText(v.getContext(), "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                        finish();
                    } else {
                        Toast.makeText(v.getContext(), "Đăng ký thất bại", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}