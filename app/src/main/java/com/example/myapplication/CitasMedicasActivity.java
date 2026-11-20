package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CitasMedicasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citas_medicas);

        Button btnAgendarCita = findViewById(R.id.btnAgendarCita);
        Button btnVolver = findViewById(R.id.btnVolver);

        btnAgendarCita.setOnClickListener(v -> {
            Toast.makeText(
                    CitasMedicasActivity.this,
                    "Cita preparada para agendar",
                    Toast.LENGTH_SHORT
            ).show();
        });

        btnVolver.setOnClickListener(v -> {
            finish();
        });
    }
}