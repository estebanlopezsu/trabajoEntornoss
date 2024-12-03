package com.example.proyectofinalentornos.service;

import com.example.proyectofinalentornos.domain.Administrador;
import com.example.proyectofinalentornos.domain.Documento;
import com.example.proyectofinalentornos.domain.Recibo;
import com.example.proyectofinalentornos.domain.Residente;
import com.example.proyectofinalentornos.domain.Usuario;

import java.util.ArrayList;
import java.util.List;


public class UsuarioService {

    private PropiedadService propiedadService;
    private ReciboService reciboService;
    private List<Documento> documentos = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();

    public Usuario crearAdministrador(String nombre, String email, String contrasena) {
        return new Administrador(nombre, email, contrasena);
    }

    public Usuario crearResidente(String nombre, String email, String contrasena) {
        return new Residente(nombre, email, contrasena);
    }


    public PropiedadService getPropiedadService() {
        return propiedadService;
    }

    public UsuarioService() {
        this.reciboService = new ReciboService();
    }

    public void agregarRecibo(Recibo recibo) {
        reciboService.agregarRecibo(recibo);
    }

    public List<Recibo> consultarRecibosPendientes() {
        return reciboService.consultarRecibosPendientes();
    }

    public void pagarRecibo(int id) {
        reciboService.pagarRecibo(id);
    }
    public void agregarDocumento(Documento documento) {
        documentos.add(documento);
    }

    public Documento consultarDocumento(int id) {
        return documentos.stream()
                .filter(doc -> doc.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Documento> obtenerTodosLosDocumentos() {
        return new ArrayList<>(documentos);
    }
    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Usuario getUsuarioPorEmail(String email) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                return usuario;
            }
        }
        return null;
    }

    public boolean enviarCorreoRecuperacion(String email) {
        Usuario usuario = getUsuarioPorEmail(email);
        return usuario != null;
    }

    public boolean restablecerContrasena(String email, String nuevaContrasena) {
        Usuario usuario = getUsuarioPorEmail(email);

        if (usuario != null) {
            usuario.setContrasena(nuevaContrasena);
            return true;
        }
        return false;
    }

    public boolean actualizarInformacionResidente(String email, String nuevoNombre, String nuevaFotoPerfil, String nuevoMetodoContacto) {
        Usuario usuario = getUsuarioPorEmail(email);

        if (usuario != null && usuario instanceof Residente) {
            Residente residente = (Residente) usuario;
            residente.actualizarNombre(nuevoNombre);
            residente.actualizarFotoPerfil(nuevaFotoPerfil);
            residente.actualizarMetodoPreferidoContacto(nuevoMetodoContacto);
            return true;
        }

        return false;
    }

}
