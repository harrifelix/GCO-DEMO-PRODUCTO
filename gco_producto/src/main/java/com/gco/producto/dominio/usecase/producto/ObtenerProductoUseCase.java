package com.gco.producto.dominio.usecase.producto;

import com.gco.producto.dominio.usecase.entities.Producto;
import com.gco.producto.infraestructura.adapters.repositorio.RepositorioProductoPersistente;
import org.springframework.stereotype.Component;

@Component
public class ObtenerProductoUseCase {

    private final RepositorioProductoPersistente repositorioLibro;

    public ObtenerProductoUseCase(RepositorioProductoPersistente repositorioLibro) {
        this.repositorioLibro = repositorioLibro;
    }

    public Producto ejecutar(String id) {
        return this.repositorioLibro.obtenerById(id);
    }
}
