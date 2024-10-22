package com.example.adopet_meu_projeto.repository;

import com.example.adopet_meu_projeto.domain.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
}
