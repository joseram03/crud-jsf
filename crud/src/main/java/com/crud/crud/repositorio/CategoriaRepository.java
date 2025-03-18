package com.crud.crud.repositorio;

import com.crud.crud.modelo.Categoria;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CategoriaRepository {

    @PersistenceContext(unitName = "jsf-crud-unit")
    private EntityManager entityManager;

    public void crear(Categoria categoria) {
        entityManager.persist(categoria);
    }

    public void actualizar(Categoria categoria) {
        entityManager.merge(categoria);
    }

    public void eliminar(Long id) {
        Categoria categoria = entityManager.find(Categoria.class, id);
        if (categoria != null) {
            entityManager.remove(categoria);
        }
    }

    public Categoria buscarPorId(Long id) {
        return entityManager.find(Categoria.class, id);
    }

    public List<Categoria> listarTodos() {
        return entityManager.createQuery("SELECT c FROM Categoria c", Categoria.class).getResultList();
    }
}
