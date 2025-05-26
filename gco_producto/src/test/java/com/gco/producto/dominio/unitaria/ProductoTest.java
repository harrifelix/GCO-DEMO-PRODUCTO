package com.gco.producto.dominio.unitaria;

import org.junit.Test;
import com.gco.producto.testdatabuilder.*;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import  com.gco.producto.dominio.usecase.entities.*;
import  com.gco.producto.dominio.gateway.*;
import com.gco.producto.dominio.usecase.producto.*;
import java.util.*;
import  com.gco.producto.infraestructura.adapters.repositorio.*;
public class ProductoTest {

    @Test
    public void Insertar() {

        // arrange
        Producto producto = new ProductoTestDataBuilder().build();

        RepositorioProductoGateway repositorioProductoGateway = mock(RepositorioProductoGateway.class);


        when(repositorioProductoGateway.obtenerById("1")).thenReturn(producto);

        CrearProductoUseCase crearProductoUseCase = new CrearProductoUseCase(repositorioProductoGateway);

        // act
        crearProductoUseCase.ejecutar(producto);

    }

    @Test
    public void Listar() {

        Producto producto = new ProductoTestDataBuilder().build();
        List<Producto> lista=new ArrayList<Producto>();

        lista.add(producto);
        RepositorioProductoPersistente repositorioProductoGateways = mock(RepositorioProductoPersistente.class);


        ObtenerProductosUseCase obtenerProductosUseCase = new ObtenerProductosUseCase(repositorioProductoGateways);
        when(repositorioProductoGateways.getAll()).thenReturn(lista);

        // act
        List<Producto> productoList = obtenerProductosUseCase.ejecutar();

        //assert
        // assertTrue(existeProducto);
    }

}
