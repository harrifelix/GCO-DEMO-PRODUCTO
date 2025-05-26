package com.gco.producto.dominio.usecase.producto;

import com.gco.producto.dominio.usecase.entities.Producto;
import com.gco.producto.infraestructura.adapters.repositorio.RepositorioProductoPersistente;
import org.springframework.stereotype.Component;

@Component
public class ObtenerProductoUseCase {

    private final RepositorioProductoPersistente repositorioProductoPersistente;

    public ObtenerProductoUseCase(RepositorioProductoPersistente repositorioProductoPersistente) {
        this.repositorioProductoPersistente = repositorioProductoPersistente;
    }

    public Producto ejecutar(String id) {
        return this.repositorioProductoPersistente.obtenerById(id);
    }
}
