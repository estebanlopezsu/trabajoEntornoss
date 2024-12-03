package com.example.proyectofinalentornos.domain;

public class Permisos {
    private boolean puedeBorrar;
    private boolean puedeAgregar;
    private boolean puedeSeleccionar;
    private boolean puedeActualizar;

    // Constructor
    public Permisos(boolean puedeBorrar, boolean puedeAgregar, boolean puedeSeleccionar, boolean puedeActualizar) {
        this.puedeBorrar = puedeBorrar;
        this.puedeAgregar = puedeAgregar;
        this.puedeSeleccionar = puedeSeleccionar;
        this.puedeActualizar = puedeActualizar;
    }

    // Métodos getters
    public boolean puedeBorrar() { return puedeBorrar; }
    public boolean puedeAgregar() { return puedeAgregar; }
    public boolean puedeSeleccionar() { return puedeSeleccionar; }
    public boolean puedeActualizar() { return puedeActualizar; }
}
