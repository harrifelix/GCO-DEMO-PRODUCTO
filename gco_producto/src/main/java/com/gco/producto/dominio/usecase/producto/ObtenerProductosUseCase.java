package com.gco.producto.dominio.usecase.producto;

import com.gco.producto.dominio.usecase.entities.Producto;
import com.gco.producto.infraestructura.adapters.repositorio.RepositorioProductoPersistente;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class ObtenerProductosUseCase {

    private final RepositorioProductoPersistente repositorioLibro;

    public ObtenerProductosUseCase(RepositorioProductoPersistente repositorioLibro) {
        this.repositorioLibro = repositorioLibro;
    }

    public List<Producto> ejecutar() {
        return this.repositorioLibro.getAll();
    }
}
