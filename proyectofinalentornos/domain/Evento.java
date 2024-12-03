package com.example.proyectofinalentornos.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Evento {
    private int id;
    private String titulo;
    private String descripcion;
    private Date fechaProgramada;
    private List<Residente> asistentes;

    public Evento(int id, String titulo, String descripcion, Date fechaProgramada) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaProgramada = fechaProgramada;
        this.asistentes = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFechaProgramada() {
        return fechaProgramada;
    }

    public List<Residente> getAsistentes() {
        return asistentes;
    }

    public void agregarAsistente(Residente residente) {
        asistentes.add(residente);
    }
}
