package com.example.proyectofinalentornos;

import static org.junit.Assert.*;

import com.example.proyectofinalentornos.domain.Administrador;
import com.example.proyectofinalentornos.domain.Documento;
import com.example.proyectofinalentornos.domain.Pago;
import com.example.proyectofinalentornos.domain.Permisos;
import com.example.proyectofinalentornos.domain.Recibo;
import com.example.proyectofinalentornos.domain.Residente;
import com.example.proyectofinalentornos.domain.Usuario;
import com.example.proyectofinalentornos.service.UsuarioService;


import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class UsuarioServiceTest {

    @Test
    public void sePuedeCrearUsuariosComoResidentesYAdministradoresYCadaUsuarioTieneSusPermisos() {
        UsuarioService usuarioService = new UsuarioService();
        Usuario admin = usuarioService.crearAdministrador("Admin Sebas", "admin@example.com", "admin123");

        assertEquals("Admin Sebas", admin.getNombre());
        assertTrue(admin.getPermisos().puedeBorrar());
        assertTrue(admin.getPermisos().puedeAgregar());
        assertTrue(admin.getPermisos().puedeSeleccionar());
        assertTrue(admin.getPermisos().puedeActualizar());

        UsuarioService residenteService = new UsuarioService();
        Usuario residente = residenteService.crearResidente("Residente Andres", "residente@example.com", "residente123");

        assertEquals("Residente Andres", residente.getNombre());
        assertFalse(residente.getPermisos().puedeBorrar());
        assertTrue(residente.getPermisos().puedeAgregar());
        assertTrue(residente.getPermisos().puedeSeleccionar());
        assertFalse(residente.getPermisos().puedeActualizar());
    }

    @Test
    public void unResidentePuedeConsultarYPagarRecibos() {
        UsuarioService usuarioService = new UsuarioService();

        Recibo recibo1 = new Recibo(1, 50000, new Date(), new Date(), "Mantenimiento enero");
        Recibo recibo2 = new Recibo(2, 60000, new Date(), new Date(), "Mantenimiento febrero");

        usuarioService.agregarRecibo(recibo1);
        usuarioService.agregarRecibo(recibo2);

        assertEquals(2, usuarioService.consultarRecibosPendientes().size());

        usuarioService.pagarRecibo(1);
        assertTrue(recibo1.isPagado());

        assertEquals(1, usuarioService.consultarRecibosPendientes().size());
    }
    @Test
    public void unUsuarioPuedeGuardarYConsultarDocumentos9() {
        UsuarioService usuarioService = new UsuarioService();

        Documento reglamento = new Documento(1, "Reglamento Interno", "Contenido del reglamento interno");
        Documento politica = new Documento(2, "Políticas de Convivencia", "Contenido de las políticas de convivencia");


        usuarioService.agregarDocumento(reglamento);
        usuarioService.agregarDocumento(politica);


        Documento resultado = usuarioService.consultarDocumento(1);
        assertNotNull(resultado);
        assertEquals("Reglamento Interno", resultado.getNombre());


        List<Documento> todosLosDocumentos = usuarioService.obtenerTodosLosDocumentos();
        assertEquals(2, todosLosDocumentos.size());
    }

    @Test
    public void SePuedeRecuperarContrasena() {
        UsuarioService usuarioService = new UsuarioService();
        usuarioService.registrarUsuario(new Administrador("Admin", "admin@mail.com", "admin123"));
        usuarioService.registrarUsuario(new Residente("Residente", "residente@mail.com", "residente123"));

        boolean correoEnviadoAdmin = usuarioService.enviarCorreoRecuperacion("admin@mail.com");
        assertTrue(correoEnviadoAdmin);

        boolean correoEnviadoResidente = usuarioService.enviarCorreoRecuperacion("residente@mail.com");
        assertTrue(correoEnviadoResidente);

        boolean correoEnviadoInexistente = usuarioService.enviarCorreoRecuperacion("noexiste@mail.com");
        assertFalse(correoEnviadoInexistente);

        boolean contrasenaRestablecidaAdmin = usuarioService.restablecerContrasena("admin@mail.com", "nuevaClave456");
        assertTrue(contrasenaRestablecidaAdmin);

        Usuario admin = usuarioService.getUsuarioPorEmail("admin@mail.com");
        assertEquals("nuevaClave456", admin.getContrasena());

        Usuario inexistente = usuarioService.getUsuarioPorEmail("noexiste@mail.com");
        assertNull(inexistente);
    }

    @Test
    public void ActualizarInformacionResidente() {
        UsuarioService usuarioService = new UsuarioService();

        Residente residente = new Residente("Juan Pérez", "juan@mail.com", "12345");
        residente.actualizarFotoPerfil("foto1.jpg");
        residente.actualizarMetodoPreferidoContacto("email");

        usuarioService.registrarUsuario(residente);

        boolean informacionActualizada = usuarioService.actualizarInformacionResidente("juan@mail.com", "Juan Pérez Actualizado", "foto2.jpg", "telefono");
        assertTrue(informacionActualizada);

        assertEquals("Juan Pérez Actualizado", residente.getNombre());
        assertEquals("foto2.jpg", residente.getFotoPerfil());
        assertEquals("telefono", residente.getMetodoPreferidoContacto());
    }

    @Test
    public void NoSePuedeActualizarInformacionDeUnUsuariosNoRegistrado() {

        UsuarioService usuarioService = new UsuarioService();

        boolean informacionActualizada = usuarioService.actualizarInformacionResidente("noexiste@mail.com", "Nuevo Nombre", "nuevaFoto.jpg", "nuevaFormaContacto");
        assertFalse(informacionActualizada);
    }

    @Test
    public void testAgregarPago() {
        Residente residente = new Residente("Juan Pérez", "juan@mail.com", "12345");

        Pago pago = new Pago(LocalDate.of(2024, 12, 1), 50000, "Tarjeta de crédito");

        residente.agregarPago(pago);

        assertEquals(1, residente.obtenerHistorialPagos().size());
        assertEquals(pago, residente.obtenerHistorialPagos().get(0));
    }

    @Test
    public void UnUsuarioPuedeObtenerSuHistorialPagos() {

        Residente residente = new Residente("Juan Pérez", "juan@mail.com", "12345");

        Pago pago1 = new Pago(LocalDate.of(2024, 12, 1), 50000, "Tarjeta de crédito");
        Pago pago2 = new Pago(LocalDate.of(2024, 12, 2), 30000, "Transferencia bancaria");

        residente.agregarPago(pago1);
        residente.agregarPago(pago2);

        List<Pago> historial = residente.obtenerHistorialPagos();

        assertEquals(2, historial.size());
        assertTrue(historial.contains(pago1));
        assertTrue(historial.contains(pago2));
    }
}