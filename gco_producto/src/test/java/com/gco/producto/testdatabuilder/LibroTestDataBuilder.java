package com.gco.producto.testdatabuilder;

import com.gco.producto.aplicacion.comando.*;
import com.gco.producto.dominio.usecase.entities.*;

import java.util.Date;

public class LibroTestDataBuilder {

    private static  int id=1;
    private static  String nombre="";
    private static  String descripcion="";
    private static  double precio=23.9;
    private static  int stock=2;
    private static  String categoria="";
    private static  String codigo="";
    private static  Date fechaCreacion=null;

    public LibroTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public LibroTestDataBuilder conDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public LibroTestDataBuilder conPrecio(double precio) {
        this.precio = precio;
        return this;
    }

    public LibroTestDataBuilder conStock(int stock) {
        this.stock = stock;
        return this;
    }

    public LibroTestDataBuilder conCategoria(String categoria) {
        this.categoria = categoria;
        return this;
    }

    public LibroTestDataBuilder conCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public LibroTestDataBuilder conFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
        return this;
    }

    public Producto build() {
        return new Producto(id, nombre, descripcion,precio,stock
        ,categoria,codigo,fechaCreacion);
    }

    public ComandoProducto buildComando() {
        return new ComandoProducto(id, nombre, descripcion,precio,stock
                ,categoria,codigo,fechaCreacion);
    }
}
