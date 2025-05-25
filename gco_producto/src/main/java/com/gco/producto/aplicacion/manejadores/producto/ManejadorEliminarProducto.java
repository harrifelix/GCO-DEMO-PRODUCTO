package com.gco.producto.aplicacion.manejadores.producto;

import com.gco.producto.dominio.usecase.producto.*;
import com.gco.producto.aplicacion.fabrica.FabricaLibro;
import com.gco.producto.dominio.Producto;
import com.gco.producto.dominio.usecase.producto.CrearProductoUseCase;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ManejadorEliminarProducto {

    private final EliminarProductoUseCase eliminarProductoUseCase;
    private final FabricaLibro fabricaLibro;

    public ManejadorEliminarProducto(EliminarProductoUseCase eliminarProductoUseCase, FabricaLibro fabricaLibro) {
        this.eliminarProductoUseCase = eliminarProductoUseCase;
        this.fabricaLibro = fabricaLibro;
    }

    @Transactional
    public void ejecutar(String id) {
        this.eliminarProductoUseCase.ejecutar(id);
    }
}
