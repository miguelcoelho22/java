package com.example.adopet_meu_projeto.repository;

import com.example.adopet_meu_projeto.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Boolean existsByNomeIgnoringCase(String nome);
}
