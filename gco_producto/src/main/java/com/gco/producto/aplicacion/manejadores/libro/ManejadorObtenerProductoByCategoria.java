package com.gco.producto.aplicacion.manejadores.libro;

import com.gco.producto.dominio.Producto;
import com.gco.producto.dominio.usecase.producto.ObtenerProductoUseCase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManejadorObtenerProductoByCategoria {

    private final ObtenerProductoUseCase servicioObtenerProducto;

    public ManejadorObtenerProductoByCategoria(ObtenerProductoUseCase servicioObtenerProducto) {
        this.servicioObtenerProducto = servicioObtenerProducto;
    }

    @Transactional
    public Producto ejecutar(String isbn) {
        return this.servicioObtenerProducto.ejecutar(isbn);
    }
}
