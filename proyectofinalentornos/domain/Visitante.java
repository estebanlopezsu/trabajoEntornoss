package com.example.proyectofinalentornos.domain;

import java.util.ArrayList;
import java.util.List;

public class Visitante {
    private String nombre;
    private String documento;
    private String fechaEntrada;
    private String fechaSalida;

    public Visitante(String nombre, String documento) {
        this.nombre = nombre;
        this.documento = documento;
    }
}