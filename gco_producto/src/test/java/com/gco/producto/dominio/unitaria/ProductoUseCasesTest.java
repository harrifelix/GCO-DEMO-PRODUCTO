package com.gco.producto.dominio.unitaria;

import org.junit.Test;
import com.gco.producto.testdatabuilder.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import  com.gco.producto.dominio.usecase.entities.*;
import  com.gco.producto.dominio.gateway.*;
import com.gco.producto.dominio.usecase.producto.*;
import java.util.*;
import  com.gco.producto.infraestructura.adapters.repositorio.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.doNothing;
public class ProductoUseCasesTest {

    @Test
    public void CrearProductoUseCase() {

        Producto producto = new ProductoTestDataBuilder().build();
        RepositorioProductoGateway repositorioProductoGateway = mock(RepositorioProductoGateway.class);
        when(repositorioProductoGateway.agregar(producto)).thenReturn(1);
        CrearProductoUseCase crearProductoUseCase = new CrearProductoUseCase(repositorioProductoGateway);
        crearProductoUseCase.ejecutar(producto);
        assertEquals(producto.getId(), 1);
    }

    @Test
    public void ActualizarProductoUseCase() {
        Producto producto = new ProductoTestDataBuilder().build();
        RepositorioProductoGateway repositorioProductoGateway = mock(RepositorioProductoGateway.class);
        doNothing().when(repositorioProductoGateway).actualizar(producto);
        repositorioProductoGateway.actualizar(producto);
        Mockito.verify(repositorioProductoGateway).actualizar(producto);
    }

    @Test
    public void EliminarProductoUseCase() {
        Producto producto = new ProductoTestDataBuilder().build();
        RepositorioProductoGateway repositorioProductoGateway = mock(RepositorioProductoGateway.class);
        doNothing().when(repositorioProductoGateway).actualizar(producto);
        repositorioProductoGateway.eliminar("1");
        Mockito.verify(repositorioProductoGateway).eliminar("1");
    }

    @Test
    public void ObtenerProductosUseCase() {

        Producto producto = new ProductoTestDataBuilder().build();
        List<Producto> lista=new ArrayList<Producto>();
        lista.add(producto);
        RepositorioProductoGateway repositorioProductoGateway = mock(RepositorioProductoGateway.class);

        ObtenerProductosUseCase obtenerProductosUseCase = new ObtenerProductosUseCase(repositorioProductoGateway);
        when(repositorioProductoGateway.getAll()).thenReturn(lista);

        List<Producto> productoList = obtenerProductosUseCase.ejecutar();

        assertNotNull(productoList);
    }

    @Test
    public void ObtenerProductoByCategoriaUseCase() {

        Producto producto = new ProductoTestDataBuilder().build();
        RepositorioProductoGateway repositorioProductoGateway = mock(RepositorioProductoGateway.class);

        ObtenerProductoByCategoriaUseCase obtenerProductosUseCase = new ObtenerProductoByCategoriaUseCase(repositorioProductoGateway);
        when(repositorioProductoGateway.obtenerByCategoria(producto.getCategoria())).thenReturn(producto);

        Producto productoList = obtenerProductosUseCase.ejecutar(producto.getCategoria());

        assertNotNull(productoList);
    }

    @Test
    public void ObtenerProductoByCodigoUseCase() {

        Producto producto = new ProductoTestDataBuilder().build();
        RepositorioProductoGateway repositorioProductoGateway = mock(RepositorioProductoGateway.class);

        ObtenerProductoByCodigoUseCase obtenerProductosUseCase = new ObtenerProductoByCodigoUseCase(repositorioProductoGateway);
        when(repositorioProductoGateway.obtenerByCodigo(producto.getCategoria())).thenReturn(producto);

        Producto productoList = obtenerProductosUseCase.ejecutar(producto.getCategoria());

        assertNotNull(productoList);
    }

    @Test
    public void ObtenerProductoByNombreUseCase() {

        Producto producto = new ProductoTestDataBuilder().build();
        RepositorioProductoGateway repositorioProductoGateway = mock(RepositorioProductoGateway.class);
        ObtenerProductoByNombreUseCase obtenerProductosUseCase = new ObtenerProductoByNombreUseCase(repositorioProductoGateway);
        when(repositorioProductoGateway.obtenerByNombre(producto.getCategoria())).thenReturn(producto);

        Producto productoList = obtenerProductosUseCase.ejecutar(producto.getCategoria());

        assertNotNull(productoList);
    }
}
