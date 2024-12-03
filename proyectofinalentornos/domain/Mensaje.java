package com.example.proyectofinalentornos.domain;

import java.time.LocalDateTime;

public class Mensaje {
    private Usuario usuario;
    private String contenido;

    // Constructor, getters y setters
    public Mensaje(Usuario usuario, String contenido) {
        this.usuario = usuario;
        this.contenido = contenido;// La fecha y hora del mensaje
    }

    public String getContenido() {
        return contenido;
    }


}
