package com.gco.producto.dominio.servicio.libro;


import com.gco.producto.dominio.Libro;
import com.gco.producto.dominio.repositorio.RepositorioLibro;
import org.springframework.stereotype.Component;

@Component
public class ServicioCrearLibro {

    private final RepositorioLibro repositorioLibro;

    public ServicioCrearLibro(RepositorioLibro repositorioLibro) {
        this.repositorioLibro = repositorioLibro;
    }

    public void ejecutar(Libro libro) {
        this.repositorioLibro.agregar(libro);
    }
}
