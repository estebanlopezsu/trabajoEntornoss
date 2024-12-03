package com.example.proyectofinalentornos.domain;

public class Usuario {
    private String nombre;
    private String email;
    private String contrasena;
    private Permisos permisos;

    public Usuario(String nombre, String email, String contrasena, Permisos permisos) {
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.permisos = permisos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public Permisos getPermisos() {
        return permisos;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void actualizarNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }
}

