package com.gco.producto.dominio.usecase.entities;

import java.util.Date;
import  com.gco.producto.infraestructura.entrypoints.enums.*;



public class Movimiento {

    private final int  id;
    private final Producto producto;
    private final TipoMovimientoEnum tipo ;
    private final int cantidad;
    private final Date fecha;
    private final String descripcion;

    public Movimiento(int id,Producto producto,TipoMovimientoEnum tipo ,int cantidad,Date fecha,String descripcion) {
        this.id=id;
        this.producto=producto;
        this.tipo=tipo;
        this.cantidad=cantidad;
        this.fecha=fecha;
        this.descripcion = descripcion;
    }


    public int getId() {
        return id;
    }

    public Producto getProducto() {
        return producto;
    }

    public TipoMovimientoEnum getTipo() {
        return tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
