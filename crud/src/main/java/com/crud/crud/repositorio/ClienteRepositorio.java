package com.crud.crud.repositorio;

import com.crud.crud.modelo.Cliente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ClienteRepositorio {

    @PersistenceContext(unitName = "jsf-crud-unit")
    private EntityManager entityManager;

    public void crear(Cliente cliente) {
        entityManager.persist(cliente);
    }

    public void actualizar(Cliente cliente) {
        entityManager.merge(cliente);
    }

    public void eliminar(Long id) {
        Cliente cliente = entityManager.find(Cliente.class, id);
        if (cliente != null) {
            entityManager.remove(cliente);
        }
    }

    public Cliente buscarPorId(Long id) {
        return entityManager.find(Cliente.class, id);
    }

    public List<Cliente> listarTodos() {
        return entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
    }
}
