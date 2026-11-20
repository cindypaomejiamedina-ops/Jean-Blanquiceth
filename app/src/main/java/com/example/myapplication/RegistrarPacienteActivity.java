package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrarPacienteActivity extends AppCompatActivity {

    private EditText etIdentificacion, etNombre, etApellido, etEdad;
    private EditText etTelefono, etCorreo, etDireccion, etContactoEmergencia;
    private Button btnGuardarPaciente, btnVolver;
    private PacientesDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_pacientes);

        dbHelper = new PacientesDBHelper(this);

        etIdentificacion = findViewById(R.id.etIdentificacion);
        etNombre = findViewById(R.id.etNombre);
        etApellido = findViewById(R.id.etApellido);
        etEdad = findViewById(R.id.etEdad);
        etTelefono = findViewById(R.id.etTelefono);
        etCorreo = findViewById(R.id.etCorreo);
        etDireccion = findViewById(R.id.etDireccion);
        etContactoEmergencia = findViewById(R.id.etContactoEmergencia);

        btnGuardarPaciente = findViewById(R.id.btnGuardarPaciente);
        btnVolver = findViewById(R.id.btnVolver);

        btnGuardarPaciente.setOnClickListener(v -> guardarPaciente());

        btnVolver.setOnClickListener(v -> {
            Intent intent = new Intent(
                    RegistrarPacienteActivity.this,
                    MenuPrincipalActivity.class
            );
            startActivity(intent);
            finish();
        });
    }

    private void guardarPaciente() {
        String identificacion = etIdentificacion.getText().toString().trim();
        String nombre = etNombre.getText().toString().trim();
        String apellido = etApellido.getText().toString().trim();
        String edad = etEdad.getText().toString().trim();
        String telefono = etTelefono.getText().toString().trim();
        String correo = etCorreo.getText().toString().trim();
        String direccion = etDireccion.getText().toString().trim();
        String emergencia = etContactoEmergencia.getText().toString().trim();

        if (identificacion.isEmpty() || nombre.isEmpty() || apellido.isEmpty()) {
            Toast.makeText(this,
                    "Completa la identificación, el nombre y el apellido",
                    Toast.LENGTH_LONG).show();
            return;
        }

        boolean guardado = dbHelper.guardarPaciente(
                identificacion,
                nombre,
                apellido,
                edad,
                telefono,
                correo,
                direccion,
                emergencia
        );

        if (guardado) {
            Toast.makeText(this,
                    "Paciente guardado correctamente",
                    Toast.LENGTH_LONG).show();

            etIdentificacion.setText("");
            etNombre.setText("");
            etApellido.setText("");
            etEdad.setText("");
            etTelefono.setText("");
            etCorreo.setText("");
            etDireccion.setText("");
            etContactoEmergencia.setText("");
        } else {
            Toast.makeText(this,
                    "No se pudo guardar. Verifica que la identificación no esté repetida.",
                    Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onDestroy() {
        if (dbHelper != null) {
            dbHelper.close();
        }
        super.onDestroy();
    }
}
