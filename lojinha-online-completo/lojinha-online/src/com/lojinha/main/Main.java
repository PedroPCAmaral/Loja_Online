package com.lojinha.main;

import com.lojinha.model.*;
import com.lojinha.service.PagamentoService;

public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente(1, "Pedro", "pedro@email.com");

        Produto p1 = new Produto(1, "Notebook", 2000.0);
        Produto p2 = new Produto(2, "Mouse", 50.0);

        Pedido pedido = new Pedido(1, cliente);

        pedido.adicionarItem(new ItemPedido(p1, 1));
        pedido.adicionarItem(new ItemPedido(p2, 1));

        double total = pedido.calcularTotal();

        PagamentoService pagamento = PagamentoService.getInstance();

        pagamento.processarPagamento(total);
    }
}
