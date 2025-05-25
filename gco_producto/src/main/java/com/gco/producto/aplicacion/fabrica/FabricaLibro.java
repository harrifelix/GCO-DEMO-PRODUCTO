package com.gco.producto.aplicacion.fabrica;

import com.gco.producto.aplicacion.comando.ComandoLibro;
import com.gco.producto.dominio.Libro;
import org.springframework.stereotype.Component;

@Component
public class FabricaLibro {
    public Libro crearLibro(ComandoLibro comandoLibro) {
        return new Libro(
                comandoLibro.getId(), comandoLibro.getNombre()
                , comandoLibro.getDescripcion(), comandoLibro.getPrecio(),comandoLibro.getStock()
                ,comandoLibro.getCategoria(),comandoLibro.getCodigo(),comandoLibro.getFechaCreacion());

    }
}
