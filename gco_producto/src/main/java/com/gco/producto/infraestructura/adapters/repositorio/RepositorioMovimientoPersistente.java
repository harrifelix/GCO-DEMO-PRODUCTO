package com.gco.producto.infraestructura.adapters.repositorio;

import com.gco.producto.dominio.usecase.entities.Movimiento;
import com.gco.producto.dominio.usecase.entities.Producto;
import com.gco.producto.dominio.gateway.*;
import com.gco.producto.infraestructura.adapters.builder.*;
import com.gco.producto.infraestructura.adapters.entidad.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositorioMovimientoPersistente implements RepositorioMovimiento {

    private static final String ID = "id";

    private static final String CODIGO = "codigo";
    private static final String NOMBRE = "nombre";
    private static final String CATEGORIA = "categoria";

    private static final String PRODUCTO_FIND_BY_ALL = "Producto.findAll";
    private static final String PRODUCTO_FIND_BY_NOMBRE = "Producto.findByNombre";
    private static final String PRODUCTO_FIND_BY_CATEGORIA = "Producto.findByCategoria";
    private static final String PRODUCTO_FIND_BY_CODIGO = "Producto.findByCodigo";

    private static final String PRODUCTO_FIND_BY_ID = "Producto.findById";

    private final EntityManager entityManager;


    public RepositorioMovimientoPersistente(EntityManager entityManager) {

        this.entityManager = entityManager;

    }


    @Override
    public void agregar(Movimiento movimiento) {
        MovimientoEntity movimientoEntity = MovmientoBuilder.convertirToEntity(movimiento);
        entityManager.persist(movimientoEntity);
        entityManager.flush();
    }

    @Override
    public List<Movimiento> getAll() {
        return null;
    }
}
