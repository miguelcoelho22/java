package com.example.crud.repository;

import com.example.crud.domain.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstudanteRepository extends JpaRepository<Estudante, Long>{
    List<Estudante> findByUniversidadeId(Long id);

}
