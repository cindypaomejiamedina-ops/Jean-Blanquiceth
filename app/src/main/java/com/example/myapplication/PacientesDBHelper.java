package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PacientesDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "SaludSegura.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_PACIENTES = "pacientes";

    public PacientesDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String crearTabla = "CREATE TABLE " + TABLE_PACIENTES + " (" +
                "identificacion TEXT PRIMARY KEY, " +
                "nombre TEXT NOT NULL, " +
                "apellido TEXT NOT NULL, " +
                "edad TEXT, " +
                "telefono TEXT, " +
                "correo TEXT, " +
                "direccion TEXT, " +
                "contacto_emergencia TEXT)";
        db.execSQL(crearTabla);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // No se eliminan datos al actualizar esta versión.
    }

    public boolean guardarPaciente(
            String identificacion,
            String nombre,
            String apellido,
            String edad,
            String telefono,
            String correo,
            String direccion,
            String contactoEmergencia) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues valores = new ContentValues();

        valores.put("identificacion", identificacion);
        valores.put("nombre", nombre);
        valores.put("apellido", apellido);
        valores.put("edad", edad);
        valores.put("telefono", telefono);
        valores.put("correo", correo);
        valores.put("direccion", direccion);
        valores.put("contacto_emergencia", contactoEmergencia);

        long resultado = db.insert(TABLE_PACIENTES, null, valores);
        return resultado != -1;
    }

    public Cursor consultarPacientes(String busqueda) {
        SQLiteDatabase db = getReadableDatabase();

        if (busqueda == null || busqueda.trim().isEmpty()) {
            return db.query(
                    TABLE_PACIENTES,
                    null,
                    null,
                    null,
                    null,
                    null,
                    "nombre ASC"
            );
        }

        String patron = "%" + busqueda.trim() + "%";

        return db.query(
                TABLE_PACIENTES,
                null,
                "identificacion LIKE ? OR nombre LIKE ? OR apellido LIKE ?",
                new String[]{patron, patron, patron},
                null,
                null,
                "nombre ASC"
        );
    }

    public boolean eliminarPaciente(String identificacion) {
        SQLiteDatabase db = getWritableDatabase();

        int filas = db.delete(
                TABLE_PACIENTES,
                "identificacion = ?",
                new String[]{identificacion}
        );

        return filas > 0;
    }
}
