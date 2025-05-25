package com.gco.producto.dominio.usecase.producto;

import com.gco.producto.dominio.Producto;
import com.gco.producto.infraestructura.adapters.repositorio.RepositorioLibroPersistente;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class ObtenerProductosUseCase {

    private final RepositorioLibroPersistente repositorioLibro;

    public ObtenerProductosUseCase(RepositorioLibroPersistente repositorioLibro) {
        this.repositorioLibro = repositorioLibro;
    }

    public List<Producto> ejecutar() {
        return this.repositorioLibro.getAll();
    }
}
