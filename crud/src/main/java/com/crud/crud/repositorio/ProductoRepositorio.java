package com.crud.crud.repositorio;

import com.crud.crud.modelo.Producto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ProductoRepositorio {

    @PersistenceContext(unitName = "jsf-crud-unit")
    private EntityManager entityManager;

    public void crear(Producto producto) {
        entityManager.persist(producto);
    }

    public void actualizar(Producto producto) {
        entityManager.merge(producto);
    }

    public void eliminar(Long id) {
        Producto producto = entityManager.find(Producto.class, id);
        if (producto != null) {
            entityManager.remove(producto);
        }
    }

    public Producto buscarPorId(Long id) {
        return entityManager.find(Producto.class, id);
    }

    public List<Producto> listarTodos() {
        return entityManager.createQuery("SELECT p FROM Producto p", Producto.class).getResultList();
    }
}
