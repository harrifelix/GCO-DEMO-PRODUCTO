package com.gco.producto.dominio.usecase.producto;


import com.gco.producto.dominio.gateway.RepositorioLibro;
import org.springframework.stereotype.Component;

@Component
public class EliminarProductoUseCase {

    private final RepositorioLibro repositorioLibro;

    public EliminarProductoUseCase(RepositorioLibro repositorioLibro) {
        this.repositorioLibro = repositorioLibro;
    }

    public void ejecutar(String id) {
        this.repositorioLibro.eliminar(id);
    }
}
