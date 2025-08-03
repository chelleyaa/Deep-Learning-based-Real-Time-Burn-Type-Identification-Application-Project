package app.ij.mlwithtensorflowlite;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class registrasi extends AppCompatActivity {

    TextInputEditText editTextName, editTextEmail, editTextUniv, editTextPassword, editTextNumberDoc, editTextNameDoc;
    Button buttonReg;
    FirebaseAuth mAuth;
    FirebaseUser user;
    ProgressBar progressBar;
    FirebaseDatabase db;
    TextView textView;
    DatabaseReference databaseReference, root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);

        // Inisialisasi Firebase
        mAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("UserInfo");
        user = mAuth.getCurrentUser();
        db = FirebaseDatabase.getInstance();
        root = db.getReference("UserInfo");

        // Inisialisasi UI
        editTextName = findViewById(R.id.name);
        editTextEmail = findViewById(R.id.email);
        editTextUniv = findViewById(R.id.univ);
        editTextPassword = findViewById(R.id.password);
        editTextNumberDoc = findViewById(R.id.nodok);
        editTextNameDoc = findViewById(R.id.nama_dokter);
        buttonReg = findViewById(R.id.btn_signup);
        progressBar = findViewById(R.id.progressBar);
        textView = findViewById(R.id.btn_kembali);

        // Tombol Kembali
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), start.class);
                startActivity(intent);
                finish();
            }
        });

        // Tombol Registrasi
        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);

                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                String nama = editTextName.getText().toString();
                String univ = editTextUniv.getText().toString();
                String nomorDokter = editTextNumberDoc.getText().toString();
                String namaDokter = editTextNameDoc.getText().toString();

                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(nama) ||
                        TextUtils.isEmpty(namaDokter) || TextUtils.isEmpty(univ) || TextUtils.isEmpty(nomorDokter)) {
                    Toast.makeText(registrasi.this, "Semua bidang harus diisi.", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                    return;
                }

                // Buat akun di Firebase Authentication
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    Toast.makeText(registrasi.this, "Akun berhasil dibuat.", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), login.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(registrasi.this, "Pendaftaran gagal. Coba lagi.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                // Tambahkan data ke Firebase Database
                addDatatoFirebase(nama, namaDokter, univ, nomorDokter);
            }
        });
    }

    private void addDatatoFirebase(String name, String namaDokter, String univ, String nomorDokter) {
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            String uid = user.getUid();
            UserInfo userInfo = new UserInfo(uid, name, namaDokter, univ, nomorDokter);
            root.child(uid).setValue(userInfo).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(registrasi.this, "Data berhasil ditambahkan ke Firebase", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(registrasi.this, "Gagal menambahkan data ke Firebase", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}

