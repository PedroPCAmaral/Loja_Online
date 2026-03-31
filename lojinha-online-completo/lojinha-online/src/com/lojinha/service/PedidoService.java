package com.lojinha.service;

import com.lojinha.model.Cliente;
import com.lojinha.model.ItemPedido;
import com.lojinha.model.Pedido;
import com.lojinha.model.Produto;

public class PedidoService {
    private int sequenciaPedido = 1;

    public Pedido criarPedido(Cliente cliente) {
        return new Pedido(sequenciaPedido++, cliente);
    }

    public void adicionarItem(Pedido pedido, Produto produto, int quantidade) {
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido não pode ser nulo.");
        }

        if (produto == null) {
            throw new IllegalArgumentException("Produto não pode ser nulo.");
        }

        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
        }

        pedido.adicionarItem(new ItemPedido(produto, quantidade));
    }
}