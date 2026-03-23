
package com.lojinha.service;

public class PagamentoService {

    private static PagamentoService instancia;

    private PagamentoService() {}

    public static PagamentoService getInstancia() {
        if (instancia == null) {
            instancia = new PagamentoService();
        }
        return instancia;
    }

    public boolean processarPagamento(double valor) {
        System.out.println("Processando pagamento de R$ " + valor);
        return valor <= 1000;
    }
}
