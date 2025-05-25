package com.gco.producto.infraestructura.persistencia.builder;

import com.gco.producto.dominio.Libro;
import com.gco.producto.infraestructura.persistencia.entidad.LibroEntity;

public final class LibroBuilder {

    private LibroBuilder() {
    }

    public static Libro convertirToDominio(LibroEntity productoEntity) {
        Libro producto = null;
        if (productoEntity != null) {
            producto = new Libro(productoEntity.getId(), productoEntity.getNombre(),
                    productoEntity.getDescripcion(),productoEntity.getPrecio(),
                    productoEntity.getStock(),productoEntity.getCategoria(), productoEntity.getCodigo(),
                    productoEntity.getFechaCreacion() );
        }
        return producto;
    }


    public static LibroEntity convertirToEntity(Libro producto) {
        LibroEntity productoEntity = new LibroEntity();
        productoEntity.setId(producto.getId());
        productoEntity.setNombre(producto.getNombre());
        productoEntity.setDescripcion(producto.getDescripcion());
        productoEntity.setPrecio(producto.getPrecio());
        productoEntity.setStock(producto.getStock());
        productoEntity.setCategoria(producto.getCategoria());
        productoEntity.setCodigo(producto.getCodigo());
        productoEntity.setFechaCreacion(producto.getFechaCreacion());
        return productoEntity;
    }
}
