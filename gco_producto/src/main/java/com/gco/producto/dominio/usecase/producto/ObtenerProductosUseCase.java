package com.gco.producto.dominio.usecase.producto;

import com.gco.producto.dominio.usecase.entities.Producto;
import com.gco.producto.infraestructura.adapters.repositorio.RepositorioProductoPersistente;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class ObtenerProductosUseCase {

    private final RepositorioProductoPersistente repositorioProductoPersistente;

    public ObtenerProductosUseCase(RepositorioProductoPersistente repositorioProductoPersistente) {
        this.repositorioProductoPersistente = repositorioProductoPersistente;
    }

    public List<Producto> ejecutar() {
        return this.repositorioProductoPersistente.getAll();
    }
}
