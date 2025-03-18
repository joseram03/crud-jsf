package com.crud.crud.servicio;

import com.crud.crud.modelo.Categoria;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.util.List;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

@Named
@ViewScoped
public class CategoriaBean implements Serializable {


    private Categoria categoria;
    private List<Categoria> categorias;

    @EJB
    private CategoriaService categoriaService;

    @PostConstruct
    public void init() {
        categoria = new Categoria();
        categorias = categoriaService.listarTodos();
    }

    // Getters y Setters
    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
    public List<Categoria> getCategorias() { return categorias; }

    public void guardar() {
        categoriaService.guardar(categoria);
        categorias = categoriaService.listarTodos();
        categoria = new Categoria();
    }

    public void eliminar(Long id) {
        categoriaService.eliminar(id);
        categorias = categoriaService.listarTodos();
    }

    public void cargarCategoria(Long id) {
        Categoria categoriaEncontrada = categoriaService.buscarPorId(id);
        if (categoriaEncontrada != null) {
            this.categoria.setId(id);
            this.categoria = categoriaEncontrada;
        }
    }
}
