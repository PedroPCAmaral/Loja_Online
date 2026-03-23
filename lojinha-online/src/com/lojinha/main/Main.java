
package com.lojinha.main;

import com.lojinha.model.*;
import com.lojinha.service.PagamentoService;

public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente(1, "Joao");

        Produto p1 = new Produto(1, "Mouse", 50);
        Produto p2 = new Produto(2, "Teclado", 150);

        Pedido pedido = new Pedido(1, cliente);

        pedido.adicionarItem(new ItemPedido(p1, 2));
        pedido.adicionarItem(new ItemPedido(p2, 1));

        double total = pedido.calcularTotal();

        PagamentoService pagamento = PagamentoService.getInstancia();

        boolean aprovado = pagamento.processarPagamento(total);

        if (aprovado) {
            System.out.println("Pagamento aprovado! Pedido confirmado.");
        } else {
            System.out.println("Pagamento recusado.");
        }
    }
}
