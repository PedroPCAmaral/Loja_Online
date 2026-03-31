package com.lojinha.model;

public class Pagamento {
    private int id;
    private double valor;
    private String status;
    private int pedidoId;

    public Pagamento(int id, double valor, String status, int pedidoId) {
        this.id = id;
        this.valor = valor;
        this.status = status;
        this.pedidoId = pedidoId;
    }

    public int getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }

    public String getStatus() {
        return status;
    }

    public int getPedidoId() {
        return pedidoId;
    }

    @Override
    public String toString() {
        return "Pagamento{id=" + id +
                ", valor=" + valor +
                ", status='" + status + '\'' +
                ", pedidoId=" + pedidoId + '}';
    }
}