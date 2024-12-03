package com.example.proyectofinalentornos;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.proyectofinalentornos.domain.Administrador;
import com.example.proyectofinalentornos.domain.Residente;
import com.example.proyectofinalentornos.domain.SolicitudMantenimiento;
import com.example.proyectofinalentornos.service.MantenimientoService;

import org.junit.Test;

public class MantenimientoServiceTest {

    @Test
    public void unResidentePuedeEnviarSolicitudDeMantenimiento() {

        MantenimientoService mantenimientoService = mock(MantenimientoService.class);

        SolicitudMantenimiento solicitudMock = new SolicitudMantenimiento(1, "Fuga de agua");
        when(mantenimientoService.crearSolicitud("Fuga de agua")).thenReturn(solicitudMock);

        SolicitudMantenimiento solicitud = mantenimientoService.crearSolicitud("Fuga de agua");

        assertEquals("Fuga de agua", solicitud.getDescripcion());

        verify(mantenimientoService).crearSolicitud("Fuga de agua");
    }

}

