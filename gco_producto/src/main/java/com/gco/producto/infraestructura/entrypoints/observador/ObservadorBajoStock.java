package com.gco.producto.infraestructura.entrypoints.observador;

public class ObservadorBajoStock implements  IObservador{
    @Override
    public void Update(ISujeto sujeto) {

        System.out.println("entro al observador");

    }
}
