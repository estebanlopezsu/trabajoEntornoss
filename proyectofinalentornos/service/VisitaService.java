package com.example.proyectofinalentornos.service;

import com.example.proyectofinalentornos.domain.Residente;
import com.example.proyectofinalentornos.domain.Visitante;

import java.util.ArrayList;
import java.util.List;

public class VisitaService {
    private List<Visitante> historialVisitas = new ArrayList<>();

    public void registrarVisita(Visitante visitante) {
        historialVisitas.add(visitante);
    }

    public boolean autorizarAcceso(Residente residente, Visitante visitante) {
        return residente.autorizarVisita(visitante);
    }

    public List<Visitante> obtenerHistorial() {
        return historialVisitas;
    }
}
