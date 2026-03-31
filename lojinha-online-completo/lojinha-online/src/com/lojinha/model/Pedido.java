package com.lojinha.model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int id;
    private Cliente cliente;
    private List<ItemPedido> itens;
    private String status;

    public Pedido(int id, Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo.");
        }

        this.id = id;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.status = "CRIADO";
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (status == null || status.isBlank()) {
            throw new IllegalArgumentException("Status não pode ser vazio.");
        }
        this.status = status;
    }

    public void adicionarItem(ItemPedido item) {
        if (item == null) {
            throw new IllegalArgumentException("Item não pode ser nulo.");
        }

        if ("PAGO".equals(this.status)) {
            throw new IllegalStateException("Não é possível adicionar itens em um pedido já pago.");
        }

        itens.add(item);
    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemPedido item : itens) {
            total += item.getSubtotal();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Pedido{id=" + id + ", cliente=" + cliente.getNome() + ", total=" + calcularTotal() + ", status='" + status + "'}";
    }
}