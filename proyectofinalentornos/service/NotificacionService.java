package com.example.proyectofinalentornos.service;

import com.example.proyectofinalentornos.domain.Notificacion;
import com.example.proyectofinalentornos.domain.Usuario;

import java.util.List;

public class NotificacionService {

    public void enviarNotificacionMasiva(List<Usuario> usuarios, String contenido) {
        Notificacion notificacion = new Notificacion(contenido);

        for (Usuario usuario : usuarios) {
            System.out.println("Enviando notificación a: " + usuario.getEmail());
            System.out.println("Contenido: " + notificacion.getContenido());
        }
    }
}