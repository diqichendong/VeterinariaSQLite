package com.example.veterinariasqlite;

import java.util.Date;

public class Perro {
    private int id;
    private String nombre;
    private Date fechaNacimiento;
    private boolean estaVacunado;
    private boolean esMacho;
    private String comentarios;
    private Raza raza;
    private Propietario propietario;

    public Perro(int id, String nombre, Date fechaNacimiento, boolean estaVacunado, boolean esMacho, String comentarios, Raza raza, Propietario propietario) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.estaVacunado = estaVacunado;
        this.esMacho = esMacho;
        this.comentarios = comentarios;
        this.raza = raza;
        this.propietario = propietario;
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean isEstaVacunado() {
        return estaVacunado;
    }

    public void setEstaVacunado(boolean estaVacunado) {
        this.estaVacunado = estaVacunado;
    }

    public boolean isEsMacho() {
        return esMacho;
    }

    public void setEsMacho(boolean esMacho) {
        this.esMacho = esMacho;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }
}
