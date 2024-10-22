package com.example.adopet_meu_projeto.dto;

import com.example.adopet_meu_projeto.domain.Produto;

import java.math.BigDecimal;

public record ProdutoDTO(Long id, String nome, String descricao, BigDecimal preco) {
    public ProdutoDTO(Produto produto){
        this(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getPreco());
    }
}
