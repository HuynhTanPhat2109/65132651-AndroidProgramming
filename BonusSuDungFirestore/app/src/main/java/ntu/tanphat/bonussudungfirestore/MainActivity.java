package ntu.tanphat.bonussudungfirestore;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtPrice;
    Button btnSave, btnRead;
    TextView tvDisplay;
    FirebaseFirestore db;
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
        edtName = findViewById(R.id.edtProductName);
        edtPrice = findViewById(R.id.edtProductPrice);
        btnSave = findViewById(R.id.btnSave);
        btnRead = findViewById(R.id.btnRead);
        tvDisplay = findViewById(R.id.tvDisplay);

        db = FirebaseFirestore.getInstance();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                String priceStr = edtPrice.getText().toString();
                if(name.isEmpty() || priceStr.isEmpty()){
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }else{
                    double price = Double.parseDouble(priceStr);
                    ghiDuLieuSanPham(name, price);
                }
            }
        });
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                docDuLieuSanPham();
            }
        });
    }
    void ghiDuLieuSanPham(String name, double price){
        DocumentReference newDoc = db.collection("Products").document();

        Product p = new Product(newDoc.getId(), name, price);

        newDoc.set(p).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(MainActivity.this, "Đã lưu", Toast.LENGTH_SHORT).show();
                edtName.setText("");
                edtPrice.setText("");
            }
        });
    }
    void docDuLieuSanPham(){
        db.collection("Products").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    StringBuilder builder = new StringBuilder(); // Dùng để cộng dồn chuỗi
                    for (com.google.firebase.firestore.QueryDocumentSnapshot document : task.getResult()) {
                        Product p = document.toObject(Product.class);
                        builder.append("Tên: ").append(p.getName())
                                .append(" - Giá: ").append(p.getPrice()).append(" VNĐ\n\n");
                    }
                    // Hiển thị lên TextView để người dùng xem
                    tvDisplay.setText(builder.toString());
                }
            }
        });
    }
}