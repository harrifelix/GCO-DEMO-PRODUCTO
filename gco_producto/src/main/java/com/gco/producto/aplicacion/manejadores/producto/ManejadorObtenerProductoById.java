package com.gco.producto.aplicacion.manejadores.producto;

import com.gco.producto.dominio.Producto;
import com.gco.producto.dominio.usecase.producto.ObtenerProductoByIdUseCase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManejadorObtenerProductoById {

    private final ObtenerProductoByIdUseCase servicioObtenerProducto;

    public ManejadorObtenerProductoById(ObtenerProductoByIdUseCase servicioObtenerProducto) {
        this.servicioObtenerProducto = servicioObtenerProducto;
    }

    @Transactional
    public Producto ejecutar(String id) {
        return this.servicioObtenerProducto.ejecutar(id);
    }
}
