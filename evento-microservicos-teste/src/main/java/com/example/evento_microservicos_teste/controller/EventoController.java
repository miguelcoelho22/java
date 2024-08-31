package com.example.evento_microservicos_teste.controller;

import com.example.evento_microservicos_teste.domain.Evento;
import com.example.evento_microservicos_teste.dto.EventoDto;
import com.example.evento_microservicos_teste.dto.SubscricaoDto;
import com.example.evento_microservicos_teste.service.EventoService;
import lombok.NonNull;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService service;
    @PostMapping
    public ResponseEntity<Evento> criarEvento (@RequestBody EventoDto dto) {
        Evento evento = service.criarEvento(dto);
        return new ResponseEntity<>(evento, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Evento>> acharEventos() {
        List<Evento> eventos = service.acharEventos();
        return new ResponseEntity<>(eventos, HttpStatus.OK);
    }

    @GetMapping("/iraoAcontecer")
    public ResponseEntity<List<Evento>> acharEventoDisponiveis() {
        List<Evento> eventos = service.acharEventosDisponiveis();
        return new ResponseEntity<>(eventos, HttpStatus.OK);
    }

    @PostMapping("{id}")
    public void registrarParticipante (@PathVariable String id, SubscricaoDto dto) {
        service.registrarParticipante(id, dto.email());

    }
}
