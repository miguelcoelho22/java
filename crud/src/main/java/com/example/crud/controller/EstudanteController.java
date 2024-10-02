package com.example.crud.controller;

import com.example.crud.domain.Estudante;
import com.example.crud.service.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estudante")
public class EstudanteController {

    @Autowired
    private EstudanteService service;

    @GetMapping
    public ResponseEntity<List<Estudante>> findAll(){
        List<Estudante> estudantes = service.findAll();
        return new ResponseEntity<>(estudantes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Estudante>> findByUniversidade(@PathVariable Long id){
        List<Estudante> estudantes = service.findByUniversidade(id);
        return new ResponseEntity<>(estudantes, HttpStatus.OK);
    }

}
