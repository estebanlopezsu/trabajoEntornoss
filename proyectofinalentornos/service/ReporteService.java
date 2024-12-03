package com.example.proyectofinalentornos.service;

import com.example.proyectofinalentornos.domain.Reporte;

import java.util.ArrayList;
import java.util.List;

public class ReporteService {

    private AreaComunService areaComunService;
    private ReciboService reciboService;
    private MantenimientoService mantenimientoService;

    public ReporteService(AreaComunService areaComunService, ReciboService reciboService, MantenimientoService mantenimientoService) {
        this.areaComunService = areaComunService;
        this.reciboService = reciboService;
        this.mantenimientoService = mantenimientoService;
    }

    public List<Reporte> generarReportes() {
        List<Reporte> reportes = new ArrayList<>();

        Reporte reporteReservas = new Reporte("Reservas");
        for (String reserva : areaComunService.obtenerReservas()) {
            reporteReservas.agregarDetalle(reserva);
        }
        reportes.add(reporteReservas);

        Reporte reportePagos = new Reporte("Pagos Pendientes");
        for (String pago : reciboService.obtenerRecibosPendientes()) {
            reportePagos.agregarDetalle(pago);
        }
        reportes.add(reportePagos);

        Reporte reporteMantenimiento = new Reporte("Solicitudes de Mantenimiento");
        for (String solicitud : mantenimientoService.obtenerSolicitudesPendientes()) {
            reporteMantenimiento.agregarDetalle(solicitud);
        }
        reportes.add(reporteMantenimiento);

        return reportes;
    }
}

