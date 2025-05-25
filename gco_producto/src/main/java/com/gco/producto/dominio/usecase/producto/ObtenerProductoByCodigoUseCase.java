package com.gco.producto.dominio.usecase.producto;

import com.gco.producto.dominio.usecase.entities.Producto;
import com.gco.producto.infraestructura.adapters.repositorio.RepositorioProductoPersistente;
import org.springframework.stereotype.Component;

@Component
public class ObtenerProductoByCodigoUseCase {

    private final RepositorioProductoPersistente repositorioLibro;

    public ObtenerProductoByCodigoUseCase(RepositorioProductoPersistente repositorioLibro) {
        this.repositorioLibro = repositorioLibro;
    }

    public Producto ejecutar(String isbn) {
        return this.repositorioLibro.obtenerByCodigo(isbn);
    }
}
