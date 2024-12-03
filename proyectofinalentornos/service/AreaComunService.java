package com.example.proyectofinalentornos.service;


import com.example.proyectofinalentornos.domain.AreaComun;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AreaComunService {
    private List<AreaComun> areasComunes = new ArrayList<>();

    public AreaComunService() {
        // Ejemplo: Agregamos algunas áreas por defecto
        areasComunes.add(new AreaComun(1, "Salón de eventos", true));
        areasComunes.add(new AreaComun(2, "Gimnasio", true));
    }

    public List<AreaComun> consultarAreasDisponibles() {
        List<AreaComun> disponibles = new ArrayList<>();
        for (AreaComun area : areasComunes) {
            if (area.isDisponible()) {
                disponibles.add(area);
            }
        }
        return disponibles;
    }

    public boolean reservarArea(int id, String fecha) {
        Optional<AreaComun> area = areasComunes.stream()
                .filter(a -> a.getId() == id && a.isDisponible())
                .findFirst();

        if (area.isPresent()) {
            area.get().agregarReserva(fecha);
            return true;
        }
        return false;
    }

    public List<String> obtenerReservas() {
        List<String> reservas = new ArrayList<>();
        for (AreaComun area : areasComunes) {
            reservas.addAll(area.getReservas()); // Ya tienes el método getReservas en AreaComun
        }
        return reservas;
    }

}

