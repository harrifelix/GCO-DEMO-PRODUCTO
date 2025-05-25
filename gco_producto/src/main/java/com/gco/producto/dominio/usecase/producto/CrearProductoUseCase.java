package com.gco.producto.dominio.usecase.producto;


import com.gco.producto.dominio.Producto;
import com.gco.producto.dominio.gateway.RepositorioLibro;
import org.springframework.stereotype.Component;

@Component
public class CrearProductoUseCase {

    private final RepositorioLibro repositorioLibro;

    public CrearProductoUseCase(RepositorioLibro repositorioLibro) {
        this.repositorioLibro = repositorioLibro;
    }

    public void ejecutar(Producto producto) {
        this.repositorioLibro.agregar(producto);
    }
}
