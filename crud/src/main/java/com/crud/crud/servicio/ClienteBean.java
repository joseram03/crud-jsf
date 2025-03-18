package com.crud.crud.servicio;

import com.crud.crud.modelo.Cliente;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ClienteBean implements Serializable {

    private static final long serialVersionUID = 1L; // Requerido para serialización

    private Cliente cliente;
    private List<Cliente> clientes;

    @EJB
    private ClienteServicio clienteServicio;

    @PostConstruct
    public void init() {
        cliente = new Cliente();
        clientes = clienteServicio.listarTodos();
    }

    // Getters y Setters
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public List<Cliente> getClientes() { return clientes; }

    public void guardar() {
        clienteServicio.guardar(cliente);
        clientes = clienteServicio.listarTodos();
        cliente = new Cliente();
    }

    public void eliminar(Long id) {
        clienteServicio.eliminar(id);
        clientes = clienteServicio.listarTodos();
    }

    public void cargarCliente(Long id) {
        Cliente clienteEncontrado = clienteServicio.buscarPorId(id);
        if(clienteEncontrado != null) {
            this.cliente = clienteEncontrado; // Ya no es necesario setId
        }
    }
}
