package app.ij.mlwithtensorflowlite;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class start extends AppCompatActivity {
    Button buttonLogin, buttonRegistrasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_start);
        buttonLogin = findViewById(R.id.btn_loginNow);
        buttonRegistrasi = this.findViewById(R.id.btn_signupNow);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(start.this, login.class);
                startActivity(intent);
                finish();
            }
        });
        buttonRegistrasi.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(start.this, registrasi.class);
                startActivity(intent);
                finish();
            }
        }));
    }
}