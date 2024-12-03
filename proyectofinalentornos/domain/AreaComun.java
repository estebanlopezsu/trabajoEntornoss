package com.example.proyectofinalentornos.domain;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class AreaComun {
    private int id;
    private String tipo;
    private boolean disponible;
    private List<String> reservas; // Lista de fechas reservadas

    public AreaComun(int id, String tipo, boolean disponible) {
        this.id = id;
        this.tipo = tipo;
        this.disponible = disponible;
        this.reservas = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public List<String> getReservas() {
        return reservas;
    }

    public void agregarReserva(String fecha) {
        this.reservas.add(fecha);
        this.disponible = false; // Marcar como no disponible
    }
}

