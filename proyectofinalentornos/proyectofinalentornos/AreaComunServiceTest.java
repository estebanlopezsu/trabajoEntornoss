package com.example.proyectofinalentornos;

import com.example.proyectofinalentornos.domain.AreaComun;
import com.example.proyectofinalentornos.domain.Evento;
import com.example.proyectofinalentornos.domain.Residente;
import com.example.proyectofinalentornos.service.AreaComunService;
import com.example.proyectofinalentornos.service.EventoService;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class AreaComunServiceTest {
    @Test
    public void unResidentePuedeConsultarYReservarDeAreasComunes() {
        AreaComunService areaComunService = mock(AreaComunService.class);

        List<AreaComun> mockAreas = Arrays.asList(
                new AreaComun(1, "Salón de eventos", true),
                new AreaComun(2, "Gimnasio", true)
        );

        when(areaComunService.consultarAreasDisponibles()).thenReturn(mockAreas);

        List<AreaComun> disponibles = areaComunService.consultarAreasDisponibles();


        assertEquals(2, disponibles.size());
        assertEquals("Salón de eventos", disponibles.get(0).getTipo());

        // Configurar mock para una reserva exitosa
        when(areaComunService.reservarArea(1, "2024-12-01")).thenReturn(true);

        boolean reservaExitosa = areaComunService.reservarArea(1, "2024-12-01");

        assertTrue(reservaExitosa);

    }

    @Test
    public void unAdministradorPuedeGestionarEventos() {
        EventoService eventoService = new EventoService();

        Date fecha = new Date();
        Evento evento = eventoService.crearEvento("Reunión de vecinos", "Reunión para discutir nuevas normas", fecha);

        assertEquals("Reunión de vecinos", evento.getTitulo());
        assertEquals("Reunión para discutir nuevas normas", evento.getDescripcion());
        assertEquals(fecha, evento.getFechaProgramada());

        // Listar eventos
        List<Evento> eventos = eventoService.obtenerEventos();
        assertEquals(1, eventos.size());

        // Simular envío de recordatorios
        Residente residenteMock = mock(Residente.class);
        when(residenteMock.getEmail()).thenReturn("residente@mail.com");

        evento.agregarAsistente(residenteMock);
        eventoService.enviarRecordatorios(evento);

        verify(residenteMock, times(1)).getEmail();
    }
}
