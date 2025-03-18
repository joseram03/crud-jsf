package com.crud.crud.servicio;

import com.crud.crud.modelo.Producto;
import com.crud.crud.repositorio.ProductoRepositorio;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ProductoServicio {

    @EJB
    private ProductoRepositorio productoRepositorio;

    public void guardar(Producto producto) {
        if (producto.getId() == null) {
            productoRepositorio.crear(producto);
        } else {
            productoRepositorio.actualizar(producto);
        }
    }

    public void eliminar(Long id) {
        productoRepositorio.eliminar(id);
    }

    public Producto buscarPorId(Long id) {
        return productoRepositorio.buscarPorId(id);
    }

    public List<Producto> listarTodos() {
        return productoRepositorio.listarTodos();
    }
}
