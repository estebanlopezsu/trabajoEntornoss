package com.example.proyectofinalentornos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.proyectofinalentornos.domain.Residente;
import com.example.proyectofinalentornos.domain.Visitante;
import com.example.proyectofinalentornos.service.VisitaService;

import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Test;
import java.util.List;

    public class VisitaServiceTest {

        @Test
        public void unResidentePuedeRegistrarYAutorizarVisita() {
            Residente residenteMock = mock(Residente.class);
            Visitante visitanteMock = mock(Visitante.class);

            VisitaService visitaService = new VisitaService();

            when(residenteMock.autorizarVisita(visitanteMock)).thenReturn(true);

            visitaService.registrarVisita(visitanteMock);

            List<Visitante> historial = visitaService.obtenerHistorial();
            assertEquals(1, historial.size());
            assertEquals(visitanteMock, historial.get(0));

            boolean accesoAutorizado = visitaService.autorizarAcceso(residenteMock, visitanteMock);
            assertTrue(accesoAutorizado);

        }
    }
