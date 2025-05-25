package com.gco.producto.aplicacion.manejadores.libro;

import com.gco.producto.aplicacion.comando.ComandoLibro;
import com.gco.producto.aplicacion.fabrica.FabricaLibro;
import com.gco.producto.dominio.Libro;
import com.gco.producto.dominio.servicio.libro.ServicioCrearLibro;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ManejadorActualizarLibro {

    private final ServicioCrearLibro servicioCrearLibro;
    private final FabricaLibro fabricaLibro;

    public ManejadorActualizarLibro(ServicioCrearLibro servicioCrearLibro, FabricaLibro fabricaLibro) {
        this.servicioCrearLibro = servicioCrearLibro;
        this.fabricaLibro = fabricaLibro;
    }

    @Transactional
    public void ejecutar(ComandoLibro comandoLibro) {
        Libro libro = this.fabricaLibro.crearLibro(comandoLibro);
        this.servicioCrearLibro.ejecutar(libro);
    }
}
