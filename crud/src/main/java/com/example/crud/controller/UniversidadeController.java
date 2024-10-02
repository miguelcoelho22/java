package com.example.crud.controller;

import com.example.crud.domain.EstudanteDto;
import com.example.crud.domain.Universidade;
import com.example.crud.domain.UniversidadeDto;
import com.example.crud.service.UniversidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/universidades")
public class UniversidadeController {

    @Autowired
    private UniversidadeService service;

    @PostMapping
    private ResponseEntity<Universidade> save (@RequestBody UniversidadeDto dto) {
        Universidade universidade = service.save(dto);
        return new ResponseEntity<>(universidade, HttpStatus.CREATED);
    }

    @GetMapping
    private ResponseEntity<List<Universidade>> findAll(){
        List<Universidade> universidades = service.findAll();

        return new ResponseEntity<>(universidades, HttpStatus.OK);
    }

    @PostMapping("/{id}/registrar")
    public ResponseEntity saveUniversitario(@PathVariable Long id, @RequestBody EstudanteDto dto) throws Exception {
        service.registrarUniversitario(id, dto);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
