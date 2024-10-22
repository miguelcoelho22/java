package com.example.adopet_meu_projeto.service;

import com.example.adopet_meu_projeto.domain.Estoque;
import com.example.adopet_meu_projeto.domain.Produto;
import com.example.adopet_meu_projeto.dto.CadastroProdutoDto;
import com.example.adopet_meu_projeto.dto.ProdutoDTO;
import com.example.adopet_meu_projeto.exception.ValidacaoException;
import com.example.adopet_meu_projeto.repository.EstoqueRepository;
import com.example.adopet_meu_projeto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EstoqueRepository estoqueRepository;

    public ProdutoDTO cadastrar(CadastroProdutoDto dto) {
       var jaCadastrado = produtoRepository.existsByNomeIgnoringCase(dto.nome());
       if(jaCadastrado){
           throw new ValidacaoException("produto ja cadastrado anteriormente");
       }

        Produto produto = new Produto(dto);
        Estoque estoque = new Estoque(produto, dto.estoqueInicial());

        produtoRepository.save(produto);
        estoqueRepository.save(estoque);

        return new ProdutoDTO(produto);


    }

    public Page<ProdutoDTO> listar(Pageable pageable) {
        return produtoRepository.findAll(pageable).map(ProdutoDTO::new);
    }

    public void excluir(Long id) {
        Produto produto = produtoRepository.findById(id).get();
        produto.setAtivo(Boolean.FALSE);
    }
}
