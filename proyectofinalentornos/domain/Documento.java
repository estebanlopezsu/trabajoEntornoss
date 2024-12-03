package com.example.proyectofinalentornos.domain;

public class Documento {
    private int id;
    private String nombre;
    private String contenido;

    public Documento(int id, String nombre, String contenido) {
        this.id = id;
        this.nombre = nombre;
        this.contenido = contenido;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

}
