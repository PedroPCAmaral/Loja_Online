package com.lojinha.service;

import com.lojinha.model.Pagamento;
import com.lojinha.model.Pedido;

public class PagamentoService {

    private static PagamentoService instance;
    private int sequenciaPagamento = 1;

    private PagamentoService() {
    }

    /* Singleton */
    public static PagamentoService getInstance() {
        if (instance == null) {
            instance = new PagamentoService();
        }
        return instance;
    }

    public Pagamento processarPagamento(Pedido pedido) {
        double valor = pedido.calcularTotal();

        String status;
        if (valor > 0) {
            status = "APROVADO";
            pedido.setStatus("PAGO");
        } else {
            status = "RECUSADO";
            pedido.setStatus("PAGAMENTO_NEGADO");
        }

        return new Pagamento(sequenciaPagamento++, valor, status, pedido.getId());
    }
}