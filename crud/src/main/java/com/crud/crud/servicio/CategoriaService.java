package com.crud.crud.servicio;

import com.crud.crud.modelo.Categoria;
import com.crud.crud.repositorio.CategoriaRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class CategoriaService {

    @EJB
    private CategoriaRepository categoriaRepository;

    public void guardar(Categoria categoria) {
        if (categoria.getId() == null) {
            categoriaRepository.crear(categoria);
        } else {
            categoriaRepository.actualizar(categoria);
        }
    }

    public void eliminar(Long id) {
        categoriaRepository.eliminar(id);
    }

    public Categoria buscarPorId(Long id) {
        return categoriaRepository.buscarPorId(id);
    }

    public List<Categoria> listarTodos() {
        return categoriaRepository.listarTodos();
    }
}
