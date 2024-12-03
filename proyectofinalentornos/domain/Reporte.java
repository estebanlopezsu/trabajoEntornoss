package com.example.proyectofinalentornos.domain;

import java.util.ArrayList;
import java.util.List;

public class Reporte {
    private String categoria;
    private List<String> detalles;

    public Reporte(String categoria) {
        this.categoria = categoria;
        this.detalles = new ArrayList<>();
    }

    public String getCategoria() {
        return categoria;
    }

    public List<String> getDetalles() {
        return detalles;
    }

    public void agregarDetalle(String detalle) {
        this.detalles.add(detalle);
    }
}
