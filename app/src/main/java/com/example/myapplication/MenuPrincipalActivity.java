package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MenuPrincipalActivity extends AppCompatActivity {

    private Button btnRegistrarPaciente;
    private Button btnConsultarPaciente;
    private Button btnServicios;
    private Button btnCitas;
    private Button btnContacto;
    private Button btnInformacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        // Referencias de los botones
        btnRegistrarPaciente = findViewById(R.id.btnRegistrarPaciente);
        btnConsultarPaciente = findViewById(R.id.btnConsultarPaciente);
        btnServicios = findViewById(R.id.btnServicios);
        btnCitas = findViewById(R.id.btnCitas);
        btnContacto = findViewById(R.id.btnContacto);
        btnInformacion = findViewById(R.id.btnInformacion);

        // Registrar paciente
        btnRegistrarPaciente.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MenuPrincipalActivity.this,
                    RegistrarPacienteActivity.class
            );
            startActivity(intent);
        });

        // Consultar pacientes
        btnConsultarPaciente.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MenuPrincipalActivity.this,
                    ConsultarPacientesActivity.class
            );
            startActivity(intent);
        });

        // Servicios médicos
        btnServicios.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MenuPrincipalActivity.this,
                    ServiciosActivity.class
            );
            startActivity(intent);
        });

        // Citas médicas
        btnCitas.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MenuPrincipalActivity.this,
                    CitasMedicasActivity.class
            );
            startActivity(intent);
        });

        // Contacto
        btnContacto.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MenuPrincipalActivity.this,
                    ContactoActivity.class
            );
            startActivity(intent);
        });

        // Información
        btnInformacion.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MenuPrincipalActivity.this,
                    InformacionActivity.class
            );
            startActivity(intent);
        });
    }
}