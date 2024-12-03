package com.example.proyectofinalentornos.service;

import com.example.proyectofinalentornos.domain.SolicitudMantenimiento;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class MantenimientoService {
    private List<SolicitudMantenimiento> solicitudes;


    public MantenimientoService() {
        this.solicitudes = new ArrayList<>();
    }

    public SolicitudMantenimiento crearSolicitud(String descripcion) {
        int id = solicitudes.size() + 1;
        SolicitudMantenimiento nuevaSolicitud = new SolicitudMantenimiento(id, descripcion);
        solicitudes.add(nuevaSolicitud);
        return nuevaSolicitud;
    }

    public List<String> obtenerSolicitudesPendientes() {
        List<String> pendientes = new ArrayList<>();
        for (SolicitudMantenimiento solicitud : solicitudes) {
            if (solicitud.isPendiente()) {
                pendientes.add("ID: " + solicitud.getId() + ", Descripción: " + solicitud.getDescripcion());
            }
        }
        return pendientes;
    }

}

