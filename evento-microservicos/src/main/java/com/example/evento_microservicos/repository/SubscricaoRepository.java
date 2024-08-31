package com.example.evento_microservicos.repository;

import com.example.evento_microservicos.domain.Subscricao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscricaoRepository extends JpaRepository<Subscricao, Long> {
}
