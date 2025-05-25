package com.gco.producto.aplicacion.manejadores.libro;

import com.gco.producto.dominio.Libro;
import com.gco.producto.dominio.servicio.libro.ServicioObtenerLibro;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManejadorObtenerLibro {

    private final ServicioObtenerLibro servicioObtenerProducto;

    public ManejadorObtenerLibro(ServicioObtenerLibro servicioObtenerProducto) {
        this.servicioObtenerProducto = servicioObtenerProducto;
    }

    @Transactional
    public Libro ejecutar(String isbn) {
        return this.servicioObtenerProducto.ejecutar(isbn);
    }
}
