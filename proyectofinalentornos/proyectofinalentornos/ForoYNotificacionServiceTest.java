package com.example.proyectofinalentornos;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import com.example.proyectofinalentornos.domain.Administrador;
import com.example.proyectofinalentornos.domain.Mensaje;
import com.example.proyectofinalentornos.domain.Usuario;
import com.example.proyectofinalentornos.service.ForoService;
import com.example.proyectofinalentornos.service.NotificacionService;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ForoYNotificacionServiceTest {


    @Test
    public void unResidentePuedeEnviarUnMensajeYSeEnvíaNotificacion() {

        NotificacionService notificacionService = mock(NotificacionService.class);
        ForoService foroService = mock(ForoService.class);

        Usuario residenteMock = mock(Usuario.class);
        when(residenteMock.getNombre()).thenReturn("Juan Pérez");
        when(residenteMock.getEmail()).thenReturn("juan@ejemplo.com");

        Administrador administradorMock = mock(Administrador.class);
        when(administradorMock.getNombre()).thenReturn("José Martínez");
        when(administradorMock.getEmail()).thenReturn("jose@admin.com");

        foroService.enviarMensaje(residenteMock, "¡Hola, tengo una consulta!");

        when(foroService.obtenerMensajes()).thenReturn(Arrays.asList(
                new Mensaje(residenteMock, "¡Hola, tengo una consulta!")
        ));

        assertEquals(1, foroService.obtenerMensajes().size());
        assertEquals("¡Hola, tengo una consulta!", foroService.obtenerMensajes().get(0).getContenido());

        // Verificación Se envía una notificación
        notificacionService.enviarNotificacionMasiva(Arrays.asList(residenteMock, administradorMock), "Nuevo mensaje en el foro de Juan Pérez.");
        verify(notificacionService).enviarNotificacionMasiva(anyList(), eq("Nuevo mensaje en el foro de Juan Pérez."));
    }
}
