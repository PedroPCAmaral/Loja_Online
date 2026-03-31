package com.lojinha.main;

import com.lojinha.model.Cliente;
import com.lojinha.model.ItemPedido;
import com.lojinha.model.Pagamento;
import com.lojinha.model.Pedido;
import com.lojinha.model.Produto;
import com.lojinha.service.ClienteService;
import com.lojinha.service.PagamentoService;
import com.lojinha.service.PedidoService;
import com.lojinha.service.ProdutoService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ClienteService clienteService = new ClienteService();
        ProdutoService produtoService = new ProdutoService();
        PedidoService pedidoService = new PedidoService();
        PagamentoService pagamentoService = PagamentoService.getInstance();

        Pedido pedidoAtual = null;

        int opcao;

        do {
            System.out.println("\n========== LOJINHA ONLINE ==========");
            System.out.println("1 - Listar clientes");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Criar pedido");
            System.out.println("4 - Adicionar item ao pedido");
            System.out.println("5 - Exibir pedido atual");
            System.out.println("6 - Processar pagamento");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\n=== CLIENTES ===");
                    for (Cliente cliente : clienteService.listarClientes()) {
                        System.out.println(cliente);
                    }
                    break;

                case 2:
                    System.out.println("\n=== PRODUTOS ===");
                    for (Produto produto : produtoService.listarProdutos()) {
                        System.out.println(produto);
                    }
                    break;

                case 3:
                    try {
                        System.out.println("\n=== CRIAR PEDIDO ===");
                        System.out.print("Digite o ID do cliente: ");
                        int idCliente = sc.nextInt();

                        Cliente cliente = clienteService.buscarPorId(idCliente);

                        if (cliente == null) {
                            System.out.println("Cliente não encontrado.");
                        } else {
                            pedidoAtual = pedidoService.criarPedido(cliente);
                            System.out.println("Pedido criado com sucesso!");
                            System.out.println(pedidoAtual);
                        }
                    } catch (Exception e) {
                        System.out.println("Erro ao criar pedido: " + e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        if (pedidoAtual == null) {
                            System.out.println("Nenhum pedido foi criado ainda.");
                            break;
                        }

                        System.out.println("\n=== ADICIONAR ITEM ===");
                        System.out.print("Digite o ID do produto: ");
                        int idProduto = sc.nextInt();

                        Produto produto = produtoService.buscarPorId(idProduto);

                        if (produto == null) {
                            System.out.println("Produto não encontrado.");
                            break;
                        }

                        System.out.print("Digite a quantidade: ");
                        int quantidade = sc.nextInt();

                        pedidoService.adicionarItem(pedidoAtual, produto, quantidade);
                        System.out.println("Item adicionado com sucesso!");
                    } catch (Exception e) {
                        System.out.println("Erro ao adicionar item: " + e.getMessage());
                    }
                    break;

                case 5:
                    if (pedidoAtual == null) {
                        System.out.println("Nenhum pedido foi criado.");
                    } else {
                        System.out.println("\n=== PEDIDO ATUAL ===");
                        System.out.println("ID: " + pedidoAtual.getId());
                        System.out.println("Cliente: " + pedidoAtual.getCliente().getNome());
                        System.out.println("Status: " + pedidoAtual.getStatus());

                        if (pedidoAtual.getItens().isEmpty()) {
                            System.out.println("Pedido sem itens.");
                        } else {
                            System.out.println("Itens:");
                            for (ItemPedido item : pedidoAtual.getItens()) {
                                System.out.println(item);
                            }
                            System.out.println("Total: R$ " + pedidoAtual.calcularTotal());
                        }
                    }
                    break;

                case 6:
                    try {
                        if (pedidoAtual == null) {
                            System.out.println("Nenhum pedido foi criado.");
                            break;
                        }

                        Pagamento pagamento = pagamentoService.processarPagamento(pedidoAtual);

                        System.out.println("\n=== PAGAMENTO REALIZADO ===");
                        System.out.println(pagamento);
                        System.out.println("Status final do pedido: " + pedidoAtual.getStatus());
                    } catch (Exception e) {
                        System.out.println("Erro ao processar pagamento: " + e.getMessage());
                    }
                    break;

                case 0:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }
}