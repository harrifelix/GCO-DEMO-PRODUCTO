package com.gco.producto.dominio.usecase.producto;

import com.gco.producto.dominio.Producto;
import com.gco.producto.infraestructura.adapters.repositorio.RepositorioLibroPersistente;
import org.springframework.stereotype.Component;

@Component
public class ObtenerProductoByIdUseCase {

    private final RepositorioLibroPersistente repositorioLibro;

    public ObtenerProductoByIdUseCase(RepositorioLibroPersistente repositorioLibro) {
        this.repositorioLibro = repositorioLibro;
    }

    public Producto ejecutar(String id) {
        return this.repositorioLibro.obtenerById(id);
    }
}
