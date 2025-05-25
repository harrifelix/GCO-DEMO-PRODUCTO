package com.gco.producto.dominio.gateway;


import com.gco.producto.dominio.usecase.entities.Producto;
import  com.gco.producto.dominio.usecase.entities.*;

import java.util.List;

public interface RepositorioMovimiento {

    void agregar(Movimiento movimiento,Producto productos);
    List<Movimiento> getAll();
}