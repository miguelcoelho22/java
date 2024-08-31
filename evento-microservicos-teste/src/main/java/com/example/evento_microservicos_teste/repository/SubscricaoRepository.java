package com.example.evento_microservicos_teste.repository;

import com.example.evento_microservicos_teste.domain.Subscricao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscricaoRepository extends JpaRepository<Subscricao, Long> {
}
