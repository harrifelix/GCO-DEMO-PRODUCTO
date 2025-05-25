package com.gco.producto.dominio.usecase.movimiento;


import com.gco.producto.dominio.gateway.*;
import com.gco.producto.dominio.usecase.entities.Producto;
import org.springframework.stereotype.Component;
import  com.gco.producto.dominio.usecase.entities.*;
@Component
public class CrearMovimientoUseCase {

    private final RepositorioMovimiento repositorioMovimiento;

    public CrearMovimientoUseCase(RepositorioMovimiento repositorioMovimiento) {
        this.repositorioMovimiento = repositorioMovimiento;
    }

    public void ejecutar(Movimiento movimiento,Producto productos) {
        this.repositorioMovimiento.agregar(movimiento,productos);
    }
}
