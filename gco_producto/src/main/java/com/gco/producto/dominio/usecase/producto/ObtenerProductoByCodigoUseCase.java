package com.gco.producto.dominio.usecase.producto;

import com.gco.producto.dominio.usecase.entities.Producto;
import com.gco.producto.infraestructura.adapters.repositorio.RepositorioProductoPersistente;
import org.springframework.stereotype.Component;

@Component
public class ObtenerProductoByCodigoUseCase {

    private final RepositorioProductoPersistente repositorioProductoPersistente;

    public ObtenerProductoByCodigoUseCase(RepositorioProductoPersistente repositorioProductoPersistente) {
        this.repositorioProductoPersistente = repositorioProductoPersistente;
    }

    public Producto ejecutar(String isbn) {
        return this.repositorioProductoPersistente.obtenerByCodigo(isbn);
    }
}
