package com.example.proyectofinalentornos.domain;

import java.time.LocalDate;
import java.util.Date;

public class Pago {
    private LocalDate fecha;
    private double monto;
    private String metodoPago;

    public Pago(LocalDate fecha, double monto, String metodoPago) {
        this.fecha = fecha;
        this.monto = monto;
        this.metodoPago = metodoPago;
    }

}