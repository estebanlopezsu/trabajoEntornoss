package com.example.proyectofinalentornos.service;

import com.example.proyectofinalentornos.domain.Evento;
import com.example.proyectofinalentornos.domain.Residente;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventoService {
    private List<Evento> eventos;

    public EventoService() {
        this.eventos = new ArrayList<>();
    }

    public Evento crearEvento(String titulo, String descripcion, Date fechaProgramada) {
        int id = eventos.size() + 1;
        Evento evento = new Evento(id, titulo, descripcion, fechaProgramada);
        eventos.add(evento);
        return evento;
    }

    public List<Evento> obtenerEventos() {
        return eventos;
    }

    public void enviarRecordatorios(Evento evento) {
        for (Residente residente : evento.getAsistentes()) {
            System.out.println("Enviando recordatorio a: " + residente.getEmail());
        }
    }
}
