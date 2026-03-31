package com.lojinha.service;

import com.lojinha.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoService {
    private List<Produto> produtos = new ArrayList<>();

    public ProdutoService() {
        produtos.add(new Produto(1, "Notebook", 2000.0));
        produtos.add(new Produto(2, "Mouse", 50.0));
        produtos.add(new Produto(3, "Teclado", 120.0));
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }

    public Produto buscarPorId(int id) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }
}