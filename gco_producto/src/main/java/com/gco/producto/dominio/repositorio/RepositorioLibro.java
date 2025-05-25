package com.gco.producto.dominio.repositorio;


import com.gco.producto.dominio.Libro;

import java.util.List;

public interface RepositorioLibro {

    void agregar(Libro producto);

    void actualizar(Libro producto);

    void eliminar(Libro producto);

    Libro obtenerById(String id);

    List<Libro> getAll();


    Libro obtenerByNombre(String id) ;


    Libro obtenerByCodigo(String id);


    Libro obtenerByCategoria(String id) ;


}