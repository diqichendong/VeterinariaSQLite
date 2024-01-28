package com.example.veterinariasqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class PerrosActivity extends AppCompatActivity {

    private List<Perro> listaPerros;
    private Conexion conexion;
    private SQLiteDatabase db;
    private Propietario propietario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perros);

        conexion = new Conexion(this);
        propietario = (Propietario) getIntent().getSerializableExtra("propietario");

        if (propietario.getId() < 0) {
            this.finish();
        } else {
            listaPerros = getListaPerros();
            RecyclerView rv = findViewById(R.id.rv);
            rv.setLayoutManager(new LinearLayoutManager(this));
            AdaptadorPerros adapter = new AdaptadorPerros(listaPerros);
            rv.setAdapter(adapter);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.conexion.close();
    }

    private List<Perro> getListaPerros() {
        List<Perro> res = new ArrayList<>();

        db = conexion.getReadableDatabase();
        String sql = "select p.*, r.nombre, r.caracteristicas from perro p, raza r where p.raza_id = r.id and p.propietario_id = ?";
        Cursor c = db.rawQuery(sql, new String[]{String.valueOf(propietario.getId())});

        if (c.getCount() == 0) {
            Toast.makeText(this, "No hay perros de este propietario.", Toast.LENGTH_SHORT).show();
        } else {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            while (c.moveToNext()) {
                try {
                    res.add(new Perro(
                            c.getInt(0),
                            c.getString(1),
                            format.parse(c.getString(2)),
                            c.getInt(3) == 1,
                            c.getInt(4) == 1,
                            c.getString(5),
                            new Raza(
                                    c.getInt(6),
                                    c.getString(8),
                                    c.getString(9)
                            ),
                            propietario
                    ));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }

        c.close();
        db.close();

        return res;
    }
}