package com.example.proyectofinalentornos.service;


import com.example.proyectofinalentornos.domain.Recibo;

import java.util.ArrayList;
import java.util.List;

public class ReciboService {
    public List<Recibo> recibos;

    public ReciboService() {
        this.recibos = new ArrayList<>();
    }

    public void agregarRecibo(Recibo recibo) {
        recibos.add(recibo);
    }

    public List<Recibo> consultarRecibosPendientes() {
        List<Recibo> pendientes = new ArrayList<>();
        for (Recibo recibo : recibos) {
            if (!recibo.isPagado()) {
                pendientes.add(recibo);
            }
        }
        return pendientes;
    }

    public void pagarRecibo(int id) {
        for (Recibo recibo : recibos) {
            if (recibo.getId() == id) {
                recibo.pagar();
                break;
            }
        }
    }

    public List<String> obtenerRecibosPendientes() {
        List<String> pendientes = new ArrayList<>();
        for (Recibo recibo : recibos) {
            if (!recibo.isPagado()) {
                pendientes.add("ID: " + recibo.getId() + ", Fecha Vencimiento: " );
            }
        }
        return pendientes;
    }
}

