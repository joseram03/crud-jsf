package com.crud.crud.servicio;

import com.crud.crud.modelo.Producto;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ProductoBean implements Serializable {

    private static final long serialVersionUID = 1L; // Requerido para serialización

    private Producto producto;
    private List<Producto> productos;

    @EJB
    private ProductoServicio productoServicio;

    @PostConstruct
    public void init() {
        producto = new Producto();
        productos = productoServicio.listarTodos();
    }

    // Getters y Setters
    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }
    public List<Producto> getProductos() { return productos; }

    public void guardar() {
        productoServicio.guardar(producto);
        productos = productoServicio.listarTodos();
        producto = new Producto();
    }

    public void eliminar(Long id) {
        productoServicio.eliminar(id);
        productos = productoServicio.listarTodos();
    }

    public void cargarProducto(Long id) {
        Producto productoEncontrado = productoServicio.buscarPorId(id);
        if (productoEncontrado != null) {
            this.producto = productoEncontrado;
        }
    }
}
