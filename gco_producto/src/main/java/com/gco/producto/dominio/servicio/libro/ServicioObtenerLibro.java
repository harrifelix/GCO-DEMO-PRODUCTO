package com.gco.producto.dominio.servicio.libro;

import com.gco.producto.dominio.Libro;
import com.gco.producto.infraestructura.persistencia.repositorio.RepositorioLibroPersistente;
import org.springframework.stereotype.Component;

@Component
public class ServicioObtenerLibro {

    private final RepositorioLibroPersistente repositorioLibro;

    public ServicioObtenerLibro(RepositorioLibroPersistente repositorioLibro) {
        this.repositorioLibro = repositorioLibro;
    }

    public Libro ejecutar(String isbn) {
        return this.repositorioLibro.obtenerById(isbn);
    }
}
