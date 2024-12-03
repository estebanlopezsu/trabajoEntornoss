package com.example.proyectofinalentornos.domain;


import java.util.Date;

public class Recibo {
    private int id;
    private double monto;
    private Date fechaEmision;
    private Date fechaVencimiento;
    private String descripcion;
    private boolean pagado;

    public Recibo(int id, double monto, Date fechaEmision, Date fechaVencimiento, String descripcion) {
        this.id = id;
        this.monto = monto;
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
        this.descripcion = descripcion;
        this.pagado = false;
    }

    public int getId() {
        return id;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void pagar() {
        this.pagado = true;
    }
}
