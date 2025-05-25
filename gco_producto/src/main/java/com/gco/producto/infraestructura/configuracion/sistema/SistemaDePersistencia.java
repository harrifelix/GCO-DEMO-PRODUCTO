package com.gco.producto.infraestructura.configuracion.sistema;

import com.gco.producto.dominio.gateway.RepositorioLibro;
import com.gco.producto.infraestructura.configuracion.conexion.ConexionJPA;
import com.gco.producto.infraestructura.adapters.repositorio.RepositorioLibroPersistente;

import javax.persistence.EntityManager;

public class SistemaDePersistencia {

    private final EntityManager entityManager;

    public SistemaDePersistencia() {
        this.entityManager = new ConexionJPA().createEntityManager();
    }

    public RepositorioLibro obtenerRepositorioLibros() {
        return new RepositorioLibroPersistente(entityManager);
    }


    public void iniciar() {
        entityManager.getTransaction().begin();
    }

    public void terminar() {
        entityManager.getTransaction().commit();
    }
}
