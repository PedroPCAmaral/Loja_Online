package com.lojinha.main;

import com.lojinha.model.Cliente;
import com.lojinha.model.Pagamento;
import com.lojinha.model.Pedido;
import com.lojinha.model.Produto;
import com.lojinha.service.ClienteService;
import com.lojinha.service.PagamentoService;
import com.lojinha.service.PedidoService;
import com.lojinha.service.ProdutoService;

public class Main {
    public static void main(String[] args) {
        ClienteService clienteService = new ClienteService();
        ProdutoService produtoService = new ProdutoService();
        PedidoService pedidoService = new PedidoService();

        System.out.println("=== SEJA BEM VINDO A LOJINHA ===");
        System.out.println();

        System.out.println("=== CLIENTES ===");
        for (Cliente c : clienteService.listarClientes()) {
            System.out.println(c);
        }

        System.out.println("\n=== PRODUTOS DISPONÍVEIS ===");
        for (Produto p : produtoService.listarProdutos()) {
            System.out.println(p);
        }

        Cliente cliente = clienteService.buscarPorId(1);

        Pedido pedido = pedidoService.criarPedido(1, cliente);

        pedidoService.adicionarItem(pedido, produtoService.buscarPorId(1), 1);
        pedidoService.adicionarItem(pedido, produtoService.buscarPorId(2), 2);

        pedidoService.fecharPedido(pedido);

        System.out.println("\n=== PEDIDO CRIADO ===");
        System.out.println("Cliente: " + pedido.getCliente().getNome());

        for (var item : pedido.getItens()) {
            System.out.println(item);
        }

        System.out.println("Total do pedido: " + pedido.calcularTotal());
        System.out.println("Status do pedido: " + pedido.getStatus());

        PagamentoService pagamentoService = PagamentoService.getInstance();
        Pagamento pagamento = pagamentoService.processarPagamento(pedido);

        System.out.println("\n=== PAGAMENTO ===");
        System.out.println(pagamento);

        System.out.println("\n=== STATUS FINAL DO PEDIDO ===");
        System.out.println(pedido);
    }
}