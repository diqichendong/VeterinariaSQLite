package com.example.veterinariasqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Propietario> listaPropietarios;
    private Conexion conexion;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.conexion = new Conexion(this);
        this.listaPropietarios = getListaPropietarios();

        AdaptadorPropietarios adapter = new AdaptadorPropietarios(this.listaPropietarios);
        RecyclerView rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.conexion.close();
    }

    private List<Propietario> getListaPropietarios() {
        List<Propietario> res = new ArrayList<>();

        db = conexion.getReadableDatabase();
        String sql = "select * from propietario";
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No hay propietarios en la base de datos.", Toast.LENGTH_SHORT).show();
        } else {
            while(cursor.moveToNext()) {
                res.add(new Propietario(
                        cursor.getInt(cursor.getColumnIndexOrThrow("id")),
                        cursor.getString(cursor.getColumnIndexOrThrow("nombre")),
                        cursor.getString(cursor.getColumnIndexOrThrow("apellidos")),
                        cursor.getString(cursor.getColumnIndexOrThrow("telefono")),
                        cursor.getString(cursor.getColumnIndexOrThrow("eMail"))
                ));
            }
        }

        cursor.close();
        db.close();

        return res;
    }
}