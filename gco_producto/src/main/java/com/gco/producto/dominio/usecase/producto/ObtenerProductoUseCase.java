package com.gco.producto.dominio.usecase.producto;

import com.gco.producto.dominio.Producto;
import com.gco.producto.infraestructura.adapters.repositorio.RepositorioLibroPersistente;
import org.springframework.stereotype.Component;

@Component
public class ObtenerProductoUseCase {

    private final RepositorioLibroPersistente repositorioLibro;

    public ObtenerProductoUseCase(RepositorioLibroPersistente repositorioLibro) {
        this.repositorioLibro = repositorioLibro;
    }

    public Producto ejecutar(String isbn) {
        return this.repositorioLibro.obtenerById(isbn);
    }
}
