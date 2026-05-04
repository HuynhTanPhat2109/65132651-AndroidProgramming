package ntu.tanphat.vieccanlam;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class ThemTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_them_task);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton2);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText editTextTenCV = findViewById(R.id.editTextTenCV);
                EditText editTextMessage = findViewById(R.id.editTextMessage);
                EditText editTextPriority= findViewById(R.id.edtPriority);
                EditText editTextDate = findViewById(R.id.edtDate);

                String tenCV = editTextTenCV.getText().toString();
                String mess = editTextMessage.getText().toString();
                String priority = editTextPriority.getText().toString();
                String date = editTextDate.getText().toString();

                TASKS tasks = new TASKS(tenCV, date, mess, priority);
                //Kết nối database và thêm
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference databaseReference = database.getReference("TASKS");
                String key = databaseReference.push().getKey();
                HashMap<String, Object> item = new HashMap<String, Object>();
                item.put(key, tasks.toFirebaseObject());

                databaseReference.updateChildren(item, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                        if(error == null) finish();
                    }
                });

            }
        });
    }
}