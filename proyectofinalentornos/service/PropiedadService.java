package com.example.proyectofinalentornos.service;


import com.example.proyectofinalentornos.domain.Propiedad;

import java.util.ArrayList;
import java.util.List;

public class PropiedadService {
    private List<Propiedad> propiedades;

    public PropiedadService() {
        this.propiedades = new ArrayList<>();
    }

    public void registrarPropiedad(Propiedad propiedad) {
        propiedades.add(propiedad);
    }

    public void actualizarPropiedad(int id, String tipo, String descripcion, boolean disponible) {
        for (Propiedad propiedad : propiedades) {
            if (propiedad.getId() == id) {
                propiedad.setTipo(tipo);
                propiedad.setDescripcion(descripcion);
                propiedad.setDisponible(disponible);
                break;
            }
        }
    }

    public List<Propiedad> getPropiedades() {
        return propiedades;
    }
}
