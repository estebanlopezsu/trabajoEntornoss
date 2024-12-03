package com.example.proyectofinalentornos;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.proyectofinalentornos.service.AreaComunService;
import com.example.proyectofinalentornos.service.MantenimientoService;
import com.example.proyectofinalentornos.service.ReciboService;
import com.example.proyectofinalentornos.service.ReporteService;
import com.example.proyectofinalentornos.domain.Reporte;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class GenerarReportesTest {

    @Test
    public void SePuedeGenerarReportesDeLasDistintasActividades() {

        AreaComunService areaComunServiceMock = mock(AreaComunService.class);
        ReciboService reciboServiceMock = mock(ReciboService.class);
        MantenimientoService mantenimientoServiceMock = mock(MantenimientoService.class);

        when(areaComunServiceMock.obtenerReservas()).thenReturn(Arrays.asList("Reserva Salón de eventos", "Reserva Gimnasio"));
        when(reciboServiceMock.obtenerRecibosPendientes()).thenReturn(Arrays.asList("ID: 1, Fecha Vencimiento: 2024-12-01"));
        when(mantenimientoServiceMock.obtenerSolicitudesPendientes()).thenReturn(Arrays.asList("ID: 10, Descripción: Reparación de ascensor"));

        ReporteService reporteService = new ReporteService(areaComunServiceMock, reciboServiceMock, mantenimientoServiceMock);

        List<Reporte> reportes = reporteService.generarReportes();

        assertEquals(3, reportes.size());

        assertEquals("Reservas", reportes.get(0).getCategoria());
        assertTrue(reportes.get(0).getDetalles().contains("Reserva Salón de eventos"));

        assertEquals("Pagos Pendientes", reportes.get(1).getCategoria());
        assertTrue(reportes.get(1).getDetalles().contains("ID: 1, Fecha Vencimiento: 2024-12-01"));

        assertEquals("Solicitudes de Mantenimiento", reportes.get(2).getCategoria());
        assertTrue(reportes.get(2).getDetalles().contains("ID: 10, Descripción: Reparación de ascensor"));
    }
}