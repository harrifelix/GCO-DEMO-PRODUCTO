package com.gco.producto.dominio;

import java.util.Date;

public class Prestamo {

    private final Date fechaSolicitud;
    private final Producto producto;
    private Date fechaEntregaMaxima;
    private String nombreUsuario;

    public Prestamo(Producto producto) {
        this.fechaSolicitud = new Date();
        this.producto = producto;
    }

    public Prestamo(Date fechaSolicitud, Producto producto, Date fechaEntregaMaxima, String nombreUsuario) {
        this.fechaSolicitud = fechaSolicitud;
        this.producto = producto;
        this.fechaEntregaMaxima = fechaEntregaMaxima;
        this.nombreUsuario = nombreUsuario;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public Producto getLibro() {
        return producto;
    }

    public Date getFechaEntregaMaxima() {
        return fechaEntregaMaxima;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setFechaEntregaMaxima(Date fechaEntregaMaxima) {
        this.fechaEntregaMaxima = fechaEntregaMaxima;
    }
}
