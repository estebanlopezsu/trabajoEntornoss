package com.example.proyectofinalentornos;


import com.example.proyectofinalentornos.domain.Propiedad;
import com.example.proyectofinalentornos.service.UsuarioService;
import org.junit.Test;

import static org.junit.Assert.*;

public class PropiedadTest {
    @Test
    public void unAdministradorPuedeRegistrarYActualizarPropiedades() {
        UsuarioService usuarioService = new UsuarioService();
        Propiedad propiedad = new Propiedad(1, "Apartamento", "Apartamento 101, Torre A", true);

        usuarioService.getPropiedadService().registrarPropiedad(propiedad);
        assertEquals(1, usuarioService.getPropiedadService().getPropiedades().size());


        usuarioService.getPropiedadService().actualizarPropiedad(1, "Área común", "Salón de eventos, Piso 2", false);
        Propiedad propiedadActualizada = usuarioService.getPropiedadService().getPropiedades().get(0);

        assertEquals("Área común", propiedadActualizada.getTipo());
        assertEquals("Salón de eventos, Piso 2", propiedadActualizada.getDescripcion());
        assertFalse(propiedadActualizada.isDisponible());
    }
}
