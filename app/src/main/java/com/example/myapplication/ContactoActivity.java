package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ContactoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Button btnLlamar = findViewById(R.id.btnLlamar);
        Button btnCorreo = findViewById(R.id.btnCorreo);
        Button btnVolver = findViewById(R.id.btnVolver);

        btnLlamar.setOnClickListener(v -> {
            // Aquí se implementará el Intent para realizar la llamada.
        });

        btnCorreo.setOnClickListener(v -> {
            // Aquí se implementará el Intent para enviar un correo.
        });

        btnVolver.setOnClickListener(v -> {
            finish();
        });
    }
}