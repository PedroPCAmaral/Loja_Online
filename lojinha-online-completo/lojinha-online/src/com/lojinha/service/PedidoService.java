package com.lojinha.service;

import com.lojinha.model.Cliente;
import com.lojinha.model.ItemPedido;
import com.lojinha.model.Pedido;
import com.lojinha.model.Produto;

public class PedidoService {

    public Pedido criarPedido(int idPedido, Cliente cliente) {
        return new Pedido(idPedido, cliente);
    }

    public void adicionarItem(Pedido pedido, Produto produto, int quantidade) {
        pedido.adicionarItem(new ItemPedido(produto, quantidade));
    }

    public void fecharPedido(Pedido pedido) {
        pedido.setStatus("AGUARDANDO_PAGAMENTO");
    }
}