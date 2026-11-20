package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ServiciosActivity extends AppCompatActivity {

    Button btnMedicinaGeneral;
    Button btnOdontologia;
    Button btnEnfermeria;
    Button btnLaboratorio;
    Button btnConsultaPrioritaria;
    Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicios);

        btnMedicinaGeneral = findViewById(R.id.btnMedicinaGeneral);
        btnOdontologia = findViewById(R.id.btnOdontologia);
        btnEnfermeria = findViewById(R.id.btnEnfermeria);
        btnLaboratorio = findViewById(R.id.btnLaboratorio);
        btnConsultaPrioritaria = findViewById(R.id.btnConsultaPrioritaria);
        btnVolver = findViewById(R.id.btnVolver);

        // 1. Abrir marcador telefónico
        btnMedicinaGeneral.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:6051234567"));
            startActivity(intent);
        });

        // 2. Abrir Google Maps
        btnOdontologia.setOnClickListener(v -> {
            Intent intent = new Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("geo:0,0?q=Hospital+Plato+Magdalena")
            );
            startActivity(intent);
        });

        // 3. Compartir información
        btnEnfermeria.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(
                    Intent.EXTRA_TEXT,
                    "Salud Segura - Información sobre servicios de enfermería."
            );
            startActivity(Intent.createChooser(intent, "Compartir con"));
        });

        // 4. Abrir página web
        btnLaboratorio.setOnClickListener(v -> {
            Intent intent = new Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.minsalud.gov.co")
            );
            startActivity(intent);
        });

        // 5. Marcar línea de emergencia
        btnConsultaPrioritaria.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:123"));
            startActivity(intent);
        });

        // Volver al menú
        btnVolver.setOnClickListener(v -> {
            Intent intent = new Intent(
                    ServiciosActivity.this,
                    MenuPrincipalActivity.class
            );
            startActivity(intent);
            finish();
        });
    }
}