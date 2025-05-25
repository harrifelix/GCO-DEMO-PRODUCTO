package com.gco.producto.dominio.usecase.producto;

import com.gco.producto.dominio.Producto;
import com.gco.producto.infraestructura.adapters.repositorio.RepositorioLibroPersistente;
import org.springframework.stereotype.Component;

@Component
public class ObtenerProductoByNombreUseCase {

    private final RepositorioLibroPersistente repositorioLibro;

    public ObtenerProductoByNombreUseCase(RepositorioLibroPersistente repositorioLibro) {
        this.repositorioLibro = repositorioLibro;
    }

    public Producto ejecutar(String isbn) {
        return this.repositorioLibro.obtenerByNombre(isbn);
    }
}
