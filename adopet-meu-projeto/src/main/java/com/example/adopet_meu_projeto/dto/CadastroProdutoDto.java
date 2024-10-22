package com.example.adopet_meu_projeto.dto;

import com.example.adopet_meu_projeto.domain.Produto;

import java.math.BigDecimal;

public record CadastroProdutoDto(String nome, String descricao, String categoria, BigDecimal preco, Integer estoqueInicial){


}

