package com.example.veterinariasqlite;

public class Raza {
    private int id;
    private String nombre;
    private String caracteristicas;

    public Raza(int id, String nombre, String caracteristicas) {
        this.id = id;
        this.nombre = nombre;
        this.caracteristicas = caracteristicas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
}
