package com.example.crud.service;

import com.example.crud.domain.Estudante;
import com.example.crud.repository.EstudanteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudanteService {

    @Autowired
    private EstudanteRepository repository;


    public List<Estudante> findAll() {
        return repository.findAll();
    }

    public List<Estudante> findByUniversidade(Long id) {
        return repository.findByUniversidadeId(id);
    }
}
