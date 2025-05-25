package com.gco.producto.dominio.gateway;


import com.gco.producto.dominio.Producto;

import java.util.List;

public interface RepositorioLibro {

    void agregar(Producto producto);

    void actualizar(Producto producto);

    void eliminar(Producto producto);

    Producto obtenerById(String id);

    List<Producto> getAll();


    Producto obtenerByNombre(String id) ;


    Producto obtenerByCodigo(String id);


    Producto obtenerByCategoria(String id) ;


}