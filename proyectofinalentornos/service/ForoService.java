package com.example.proyectofinalentornos.service;

import com.example.proyectofinalentornos.domain.Mensaje;
import com.example.proyectofinalentornos.domain.Usuario;

import java.util.ArrayList;
import java.util.List;

public class ForoService {
    private List<Mensaje> mensajes = new ArrayList<>();

    public void enviarMensaje(Usuario usuario, String contenido) {
        Mensaje mensaje = new Mensaje(usuario, contenido);
        mensajes.add(mensaje);
    }

    public List<Mensaje> obtenerMensajes() {
        return mensajes;
    }
}
