package com.crud.crud.servicio;

import com.crud.crud.modelo.Cliente;
import com.crud.crud.repositorio.ClienteRepositorio;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ClienteServicio {

    @EJB
    private ClienteRepositorio clienteRepositorio;

    public void guardar(Cliente cliente) {
        if (cliente.getId() == null) {
            clienteRepositorio.crear(cliente);
        } else {
            clienteRepositorio.actualizar(cliente);
        }
    }

    public void eliminar(Long id) {
        clienteRepositorio.eliminar(id);
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepositorio.buscarPorId(id);
    }

    public List<Cliente> listarTodos() {
        return clienteRepositorio.listarTodos();
    }
}
