package com.gco.producto.infraestructura.persistencia.repositorio;

import com.gco.producto.dominio.Libro;
import com.gco.producto.dominio.repositorio.RepositorioLibro;
import com.gco.producto.infraestructura.persistencia.builder.LibroBuilder;
import com.gco.producto.infraestructura.persistencia.entidad.LibroEntity;
import com.gco.producto.infraestructura.persistencia.repositorio.jpa.RepositorioLibroJPA;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositorioLibroPersistente implements RepositorioLibro {

    private static final String ID = "id";

    private static final String CODIGO = "codigo";
    private static final String NOMBRE = "nombre";
    private static final String CATEGORIA = "categoria";

    private static final String PRODUCTO_FIND_BY_ALL = "Producto.findAll";
    private static final String PRODUCTO_FIND_BY_NOMBRE = "Producto.findByNombre";
    private static final String PRODUCTO_FIND_BY_CATEGORIA = "Producto.findByCategoria";
    private static final String PRODUCTO_FIND_BY_CODIGO = "Producto.findByCodigo";

    private static final String PRODUCTO_FIND_BY_ID = "Prestamo.findByIdentificacion";

    private final EntityManager entityManager;


    public RepositorioLibroPersistente(EntityManager entityManager) {

        this.entityManager = entityManager;

    }


    @Override
    public void agregar(Libro producto) {
        LibroEntity movimientoEntity = LibroBuilder.convertirToEntity(producto);

        entityManager.persist(movimientoEntity);
        entityManager.flush();
        //movimientoEntity.setId(movimientoEntity.getId());
    }

    @Override
    public void actualizar(Libro producto) {
        LibroEntity movimientoEntity = LibroBuilder.convertirToEntity(producto);

        entityManager.merge(movimientoEntity);
        entityManager.flush();
        //movimientoEntity.setId(movimientoEntity.getId());
    }

    @Override
    public void eliminar(Libro producto) {
        LibroEntity movimientoEntity = LibroBuilder.convertirToEntity(producto);

        entityManager.remove(movimientoEntity);
        entityManager.flush();
        //movimientoEntity.setId(movimientoEntity.getId());
    }

    @Override
    public Libro obtenerById(String id) {
        LibroEntity movimientoEntity = (LibroEntity) obtenerPrestamoEntityByIdPrestamo(id);

        if (movimientoEntity == null) {
            return null;
        }

        return new Libro(
                movimientoEntity.getId(), movimientoEntity.getNombre()
                , movimientoEntity.getDescripcion(), movimientoEntity.getPrecio(),movimientoEntity.getStock()
                ,movimientoEntity.getCategoria(),movimientoEntity.getCodigo(),movimientoEntity.getFechaCreacion());

    }

    @Override
    public Libro obtenerByNombre(String id) {
        LibroEntity movimientoEntity = (LibroEntity) obtenerProductoByNombre(id);

        if (movimientoEntity == null) {
            return null;
        }

        return new Libro(
                movimientoEntity.getId(), movimientoEntity.getNombre()
                , movimientoEntity.getDescripcion(), movimientoEntity.getPrecio(),movimientoEntity.getStock()
                ,movimientoEntity.getCategoria(),movimientoEntity.getCodigo(),movimientoEntity.getFechaCreacion());

    }

    @Override
    public Libro obtenerByCodigo(String id) {
        LibroEntity movimientoEntity = (LibroEntity) obtenerProductoByCodigo(id);

        if (movimientoEntity == null) {
            return null;
        }

        return new Libro(
                movimientoEntity.getId(), movimientoEntity.getNombre()
                , movimientoEntity.getDescripcion(), movimientoEntity.getPrecio(),movimientoEntity.getStock()
                ,movimientoEntity.getCategoria(),movimientoEntity.getCodigo(),movimientoEntity.getFechaCreacion());

    }

    @Override
    public Libro obtenerByCategoria(String id) {
        LibroEntity movimientoEntity = (LibroEntity) obtenerProductoByCategoria(id);

        if (movimientoEntity == null) {
            return null;
        }

        return new Libro(
                movimientoEntity.getId(), movimientoEntity.getNombre()
                , movimientoEntity.getDescripcion(), movimientoEntity.getPrecio(),movimientoEntity.getStock()
                ,movimientoEntity.getCategoria(),movimientoEntity.getCodigo(),movimientoEntity.getFechaCreacion());

    }

    @Override
    public List<Libro> getAll() {
        List<LibroEntity> productoEntity =  obtenerTodos();
        List<Libro> listProducto=new ArrayList<Libro>();
        if (productoEntity == null) {
            return null;
        }
        for (LibroEntity p:productoEntity
        ) {
            Libro producto= new Libro(
                    p.getId(), p.getNombre()
                    , p.getDescripcion(), p.getPrecio(),p.getStock()
                    ,p.getCategoria(),p.getCodigo(),p.getFechaCreacion());
            listProducto.add(producto);
        }
        return  listProducto;
    }

    private List<LibroEntity> obtenerPrestamoEntityByIdPrestamo(String idS) {

        Query query = entityManager.createNamedQuery(PRODUCTO_FIND_BY_ID);
        long id = Long.parseLong(idS);
        query.setParameter(ID, id);

        List resultList = query.getResultList();

        return !resultList.isEmpty() ? (List<LibroEntity>) resultList : null;
    }

    private LibroEntity obtenerProductoByNombre(String isbn) {

        Query query = entityManager.createNamedQuery(PRODUCTO_FIND_BY_NOMBRE);
        query.setParameter(NOMBRE, isbn);

        List resultList = query.getResultList();

        return !resultList.isEmpty() ? (LibroEntity) resultList.get(0) : null;
    }

    private LibroEntity obtenerProductoByCodigo(String isbn) {

        Query query = entityManager.createNamedQuery(PRODUCTO_FIND_BY_CODIGO);
        query.setParameter(CODIGO, isbn);

        List resultList = query.getResultList();

        return !resultList.isEmpty() ? (LibroEntity) resultList.get(0) : null;
    }

    private LibroEntity obtenerProductoByCategoria(String isbn) {

        Query query = entityManager.createNamedQuery(PRODUCTO_FIND_BY_CATEGORIA);
        query.setParameter(CATEGORIA, isbn);

        List resultList = query.getResultList();

        return !resultList.isEmpty() ? (LibroEntity) resultList.get(0) : null;
    }

    private List<LibroEntity> obtenerTodos() {

        Query query = entityManager.createNamedQuery(PRODUCTO_FIND_BY_ALL);
        List resultList = query.getResultList();

        return !resultList.isEmpty() ? (List<LibroEntity>) resultList: null;
    }
}
