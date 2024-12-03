package com.example.proyectofinalentornos.domain;

public class SolicitudMantenimiento {
    private int id;
    private String descripcion;
    private String estado;
    private String responsable;
    private boolean pendiente;

    // Constructor
    public SolicitudMantenimiento(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = "pendiente";
        this.pendiente = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public void actualizarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public boolean isPendiente() {
        return pendiente;
    }
}

