package com.example.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ConsultarPacientesActivity extends AppCompatActivity {

    private EditText etBuscarPaciente;
    private TextView tvPacienteEjemplo;
    private Button btnBuscarPaciente, btnVolver, btnEliminarPaciente;
    private PacientesDBHelper dbHelper;
    private String identificacionSeleccionada = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_pacientes);

        dbHelper = new PacientesDBHelper(this);

        etBuscarPaciente = findViewById(R.id.etBuscarPaciente);
        tvPacienteEjemplo = findViewById(R.id.tvPacienteEjemplo);
        btnBuscarPaciente = findViewById(R.id.btnBuscarPaciente);
        btnVolver = findViewById(R.id.btnVolver);
        btnEliminarPaciente = findViewById(R.id.btnEliminarPaciente);

        btnBuscarPaciente.setOnClickListener(v ->
                mostrarPacientes(etBuscarPaciente.getText().toString().trim()));

        btnEliminarPaciente.setOnClickListener(v -> eliminarPaciente());

        btnVolver.setOnClickListener(v -> {
            Intent intent = new Intent(
                    ConsultarPacientesActivity.this,
                    MenuPrincipalActivity.class
            );
            startActivity(intent);
            finish();
        });

        mostrarPacientes("");
    }

    private void mostrarPacientes(String busqueda) {
        StringBuilder resultado = new StringBuilder();
        identificacionSeleccionada = null;

        try (Cursor cursor = dbHelper.consultarPacientes(busqueda)) {
            if (cursor == null || cursor.getCount() == 0) {
                tvPacienteEjemplo.setText(
                        "No hay pacientes registrados que coincidan con la búsqueda."
                );
                return;
            }

            while (cursor.moveToNext()) {
                String identificacion =
                        cursor.getString(cursor.getColumnIndexOrThrow("identificacion"));
                String nombre =
                        cursor.getString(cursor.getColumnIndexOrThrow("nombre"));
                String apellido =
                        cursor.getString(cursor.getColumnIndexOrThrow("apellido"));
                String edad =
                        cursor.getString(cursor.getColumnIndexOrThrow("edad"));
                String telefono =
                        cursor.getString(cursor.getColumnIndexOrThrow("telefono"));
                String correo =
                        cursor.getString(cursor.getColumnIndexOrThrow("correo"));
                String direccion =
                        cursor.getString(cursor.getColumnIndexOrThrow("direccion"));
                String emergencia =
                        cursor.getString(cursor.getColumnIndexOrThrow("contacto_emergencia"));

                if (identificacionSeleccionada == null) {
                    identificacionSeleccionada = identificacion;
                }

                resultado.append("Nombre: ").append(nombre).append(" ")
                        .append(apellido).append("\n")
                        .append("Identificación: ").append(identificacion).append("\n")
                        .append("Edad: ").append(valor(edad)).append("\n")
                        .append("Teléfono: ").append(valor(telefono)).append("\n")
                        .append("Correo: ").append(valor(correo)).append("\n")
                        .append("Dirección: ").append(valor(direccion)).append("\n")
                        .append("Contacto de emergencia: ").append(valor(emergencia))
                        .append("\n\n------------------------\n\n");
            }

            tvPacienteEjemplo.setText(resultado.toString());
        }
    }

    private String valor(String texto) {
        return texto == null || texto.trim().isEmpty() ? "No registrado" : texto;
    }

    private void eliminarPaciente() {
        if (identificacionSeleccionada == null) {
            Toast.makeText(this,
                    "Busca un paciente registrado primero",
                    Toast.LENGTH_LONG).show();
            return;
        }

        boolean eliminado =
                dbHelper.eliminarPaciente(identificacionSeleccionada);

        if (eliminado) {
            Toast.makeText(this,
                    "Paciente eliminado",
                    Toast.LENGTH_SHORT).show();
            mostrarPacientes(etBuscarPaciente.getText().toString().trim());
        } else {
            Toast.makeText(this,
                    "No se pudo eliminar el paciente",
                    Toast.LENGTH_SHORT).show();
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
