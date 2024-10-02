package com.example.crud.service;

import com.example.crud.domain.EstudanteDto;
import com.example.crud.domain.Estudante;
import com.example.crud.domain.Universidade;
import com.example.crud.domain.UniversidadeDto;
import com.example.crud.repository.EstudanteRepository;
import com.example.crud.repository.UniversidadeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversidadeService {

    @Autowired
    private UniversidadeRepository repository;

    @Autowired
    private EstudanteRepository estudanteRepository;

    public Universidade save(UniversidadeDto dto){
        return repository.save(new Universidade(dto));
    }

    public List<Universidade> findAll() {
        return repository.findAll();
    }

    public void registrarUniversitario(Long id, EstudanteDto dto) throws Exception {
        Universidade universidade = repository.findById(id).orElseThrow( () -> new EntityNotFoundException("universidade nao encontrada"));

        Estudante estudante = new Estudante(dto.nome(), dto.areaGraducao(), universidade);
        estudanteRepository.save(estudante);
    }

}
