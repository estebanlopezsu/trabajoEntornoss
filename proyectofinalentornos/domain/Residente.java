package com.example.proyectofinalentornos.domain;

import java.util.ArrayList;
import java.util.List;

// Residente.java
public class Residente extends Usuario {
    private String fotoPerfil;
    private String metodoPreferidoContacto;
    private List<Pago> historialPagos;

    public Residente(String nombre, String email, String contrasena) {
        super(nombre, email, contrasena, new Permisos(false, true, true, false));  // Permisos limitados
        this.fotoPerfil = "";
        this.metodoPreferidoContacto = "";
        this.historialPagos = new ArrayList<>();
    }

    public void actualizarFotoPerfil(String nuevaFoto) {
        this.fotoPerfil = nuevaFoto;
    }

    public void actualizarMetodoPreferidoContacto(String nuevoMetodo) {
        this.metodoPreferidoContacto = nuevoMetodo;
    }

    // Métodos de acceso para obtener los datos personales
    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public String getMetodoPreferidoContacto() {
        return metodoPreferidoContacto;
    }



    public boolean autorizarVisita(Visitante visitante) {
        return true;
    }

    public void agregarPago(Pago pago) {
        historialPagos.add(pago);
    }


    public List<Pago> obtenerHistorialPagos() {
        return historialPagos;
    }
}

