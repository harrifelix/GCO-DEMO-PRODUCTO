package com.gco.producto.aplicacion.manejadores.libro;

import com.gco.producto.aplicacion.comando.ComandoProducto;
import com.gco.producto.aplicacion.fabrica.FabricaLibro;
import com.gco.producto.dominio.Producto;
import com.gco.producto.dominio.usecase.producto.CrearProductoUseCase;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ManejadorCrearProducto {

    private final CrearProductoUseCase crearProductoUseCase;
    private final FabricaLibro fabricaLibro;

    public ManejadorCrearProducto(CrearProductoUseCase crearProductoUseCase, FabricaLibro fabricaLibro) {
        this.crearProductoUseCase = crearProductoUseCase;
        this.fabricaLibro = fabricaLibro;
    }

    @Transactional
    public void ejecutar(ComandoProducto comandoProducto) {
        Producto producto = this.fabricaLibro.crearLibro(comandoProducto);
        this.crearProductoUseCase.ejecutar(producto);
    }
}
