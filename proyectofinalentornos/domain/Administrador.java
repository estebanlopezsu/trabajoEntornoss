package com.example.proyectofinalentornos.domain;

// Administrador.java
public class Administrador extends Usuario {
    public Administrador(String nombre, String email, String contrasena) {
        super(nombre, email, contrasena, new Permisos(true, true, true, true));  // Todos los permisos habilitados
    }

    public void asignarResponsable(SolicitudMantenimiento solicitud, String responsable) {
        solicitud.setResponsable(responsable);
    }

    public void actualizarEstadoSolicitud(SolicitudMantenimiento solicitud, String nuevoEstado) {
        solicitud.actualizarEstado(nuevoEstado);
    }
}
