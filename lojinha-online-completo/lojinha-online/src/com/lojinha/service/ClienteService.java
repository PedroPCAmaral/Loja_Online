package com.lojinha.service;

import com.lojinha.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteService {
    private List<Cliente> clientes = new ArrayList<>();

    public ClienteService() {
        clientes.add(new Cliente(1, "Pedro", "pedro@email.com"));
        clientes.add(new Cliente(2, "Maria", "maria@email.com"));
        clientes.add(new Cliente(3, "João", "joao@email.com"));
    }

    public List<Cliente> listarClientes() {
        return clientes;
    }

    public Cliente buscarPorId(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }
}