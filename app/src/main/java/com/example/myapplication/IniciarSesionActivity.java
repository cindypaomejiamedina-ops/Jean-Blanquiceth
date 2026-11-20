package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class IniciarSesionActivity extends AppCompatActivity {

    private Button btnIniciarSesion;
    private Button btnCrearCuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);

        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);
        btnCrearCuenta = findViewById(R.id.btnCrearCuenta);

        // Botón Iniciar Sesión
        btnIniciarSesion.setOnClickListener(v -> {
            Intent intent = new Intent(
                    IniciarSesionActivity.this,
                    MenuPrincipalActivity.class
            );
            startActivity(intent);
        });

        // Botón Crear Cuenta
        btnCrearCuenta.setOnClickListener(v -> {
            Intent intent = new Intent(
                    IniciarSesionActivity.this,
                    RegistrarPacienteActivity.class
            );
            startActivity(intent);
        });
    }
}