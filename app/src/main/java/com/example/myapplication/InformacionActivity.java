package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class InformacionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);

        Button btnSitioWeb = findViewById(R.id.btnSitioWeb);
        Button btnVolver = findViewById(R.id.btnVolver);

        btnSitioWeb.setOnClickListener(v -> {
            // Aquí se implementará el Intent para abrir el navegador.
        });

        btnVolver.setOnClickListener(v -> {
            finish();
        });
    }
}