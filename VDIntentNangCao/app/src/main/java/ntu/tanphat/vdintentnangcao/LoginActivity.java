package ntu.tanphat.vdintentnangcao;

import android.content.Intent;
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

public class LoginActivity extends AppCompatActivity {
    EditText editTextUserName, editTextPass, editTextEmail;
    Button buttonOK;
    TextView textViewError;
    void TimDieuKhien(){
        editTextUserName = (EditText) findViewById(R.id.edtUserName);
        editTextPass = (EditText) findViewById(R.id.edtPass);
        editTextEmail = (EditText) findViewById(R.id.edtMail);
        buttonOK = (Button) findViewById(R.id.btnOK);
        textViewError = (TextView) findViewById(R.id.tvLoiSai);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TimDieuKhien();
        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = editTextUserName.getText().toString();
                String pass = editTextPass.getText().toString();
                String email = editTextEmail.getText().toString();

                if(userName.isEmpty() || pass.isEmpty() || email.isEmpty()){
                    textViewError.setText("Lỗi đăng nhập!");
                } else{
                    Intent iQuiz = new Intent(LoginActivity.this, HomeActivity.class);
                    iQuiz.putExtra("user",userName);
                    startActivity(iQuiz);
                }
            }
        });
    }
}