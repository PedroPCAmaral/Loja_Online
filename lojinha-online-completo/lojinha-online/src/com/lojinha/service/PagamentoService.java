package com.lojinha.service;

/*
 * Singleton aplicado para garantir apenas UMA instância
 * de comunicação com o sistema de pagamento externo.
 */
public class PagamentoService {

    private static PagamentoService instancia;

    private PagamentoService() {}

    public static PagamentoService getInstance() {
        if (instancia == null) {
            instancia = new PagamentoService();
        }
        return instancia;
    }

    public boolean processarPagamento(double valor) {
        System.out.println("Processando pagamento de R$ " + valor);

        if (valor > 0) {
            System.out.println("Pagamento aprovado! Pedido confirmado.");
            return true;
        } else {
            System.out.println("Pagamento recusado.");
            return false;
        }
    }
}
