package com.crud.crud.controlador;

import com.crud.crud.modelo.Cliente;
import com.crud.crud.servicio.ClienteServicio;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable {

    @EJB
    private ClienteServicio clienteServicio;

    private Cliente cliente;
    private List<Cliente> listaClientes;

    @PostConstruct
    public void init() {
        cliente = new Cliente();
        listarClientes();
    }

    public void guardarCliente() {
        clienteServicio.guardar(cliente);
        cliente = new Cliente();
        listarClientes();
    }

    public void eliminarCliente(Long id) {
        clienteServicio.eliminar(id);
        listarClientes();
    }

    public void listarClientes() {
        listaClientes = clienteServicio.listarTodos();
    }

    // Getters y Setters
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }
}
