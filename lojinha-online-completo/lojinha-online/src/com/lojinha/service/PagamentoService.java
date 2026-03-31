package com.lojinha.service;

import com.lojinha.model.Pagamento;
import com.lojinha.model.Pedido;

public class PagamentoService {

    private static PagamentoService instance;
    private int sequenciaPagamento = 1;

    private PagamentoService() {
    }

    public static PagamentoService getInstance() {
        if (instance == null) {
            instance = new PagamentoService();
        }
        return instance;
    }

    public Pagamento processarPagamento(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido não pode ser nulo.");
        }

        if (pedido.getItens().isEmpty()) {
            throw new IllegalStateException("Não é possível processar pagamento de um pedido sem itens.");
        }

        if ("PAGO".equals(pedido.getStatus())) {
            throw new IllegalStateException("Este pedido já foi pago.");
        }

        pedido.setStatus("AGUARDANDO_PAGAMENTO");

        double valor = pedido.calcularTotal();
        String statusPagamento;

        if (valor > 0) {
            statusPagamento = "APROVADO";
            pedido.setStatus("PAGO");
        } else {
            statusPagamento = "RECUSADO";
            pedido.setStatus("PAGAMENTO_NEGADO");
        }

        return new Pagamento(sequenciaPagamento++, valor, statusPagamento, pedido.getId());
    }
}