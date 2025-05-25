package com.gco.producto.dominio.usecase.producto;


import com.gco.producto.dominio.usecase.entities.Producto;
import com.gco.producto.dominio.gateway.RepositorioLibro;
import org.springframework.stereotype.Component;

@Component
public class ActualizarProductoUseCase {

    private final RepositorioLibro repositorioLibro;

    public ActualizarProductoUseCase(RepositorioLibro repositorioLibro) {
        this.repositorioLibro = repositorioLibro;
    }

    public void ejecutar(Producto producto) {
        this.repositorioLibro.actualizar(producto);
    }
}
