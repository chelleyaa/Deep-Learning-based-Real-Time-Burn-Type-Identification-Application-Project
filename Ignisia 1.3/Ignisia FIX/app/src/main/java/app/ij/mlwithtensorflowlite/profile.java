package app.ij.mlwithtensorflowlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class profile extends AppCompatActivity {

    ImageView appLogo, profileImage;
    Button logout;
    FirebaseAuth auth;
    FirebaseUser user;
    FirebaseDatabase db;
    TextView textViewReturn, textName, textUniv, textEmail, textNomorDokter, textNamaDokter;
    DatabaseReference root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Inisialisasi Firebase
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        db = FirebaseDatabase.getInstance();
        root = db.getReference("UserInfo");

        // Inisialisasi UI
        logout = findViewById(R.id.btn_logout);
        textViewReturn = findViewById(R.id.btn_kembali3);
        textName = findViewById(R.id.text_name);
        textUniv = findViewById(R.id.text_univ);
        textEmail = findViewById(R.id.text_email);
        textNomorDokter = findViewById(R.id.text_nomor_dokter);
        textNamaDokter = findViewById(R.id.text_nama_dokter);

        // Ambil data dari Firebase berdasarkan UID pengguna saat ini
        if (user != null) {
            String uid = user.getUid();
            root.child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists()) {
                        // Ambil data dari database
                        String name = snapshot.child("name").getValue(String.class);
                        String univ = snapshot.child("univ").getValue(String.class);
                        String email = snapshot.child("email").getValue(String.class);
                        String nomorDokter = snapshot.child("nomorDokter").getValue(String.class);
                        String namaDokter = snapshot.child("namaDokter").getValue(String.class);

                        // Tampilkan data di TextView
                        textName.setText(name);
                        textUniv.setText(univ);
                        textEmail.setText(email);
                        textNomorDokter.setText(nomorDokter);
                        textNamaDokter.setText(namaDokter);
                    } else {
                        Toast.makeText(profile.this, "Data tidak ditemukan.", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    Toast.makeText(profile.this, "Gagal mengambil data: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        // Tombol Logout
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut();
                Intent intent = new Intent(getApplicationContext(), login.class);
                startActivity(intent);
                finish();
            }
        });

        // Tombol Kembali
        textViewReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), homepage.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
