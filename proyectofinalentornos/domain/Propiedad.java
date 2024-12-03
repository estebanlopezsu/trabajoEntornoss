package com.example.proyectofinalentornos.domain;


public class Propiedad {
    private int id;
    private String tipo;
    private String descripcion;
    private boolean disponible;

    public Propiedad(int id, String tipo, String descripcion, boolean disponible) {
        this.id = id;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.disponible = disponible;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
