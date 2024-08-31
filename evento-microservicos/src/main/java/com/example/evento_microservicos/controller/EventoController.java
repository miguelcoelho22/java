package com.example.evento_microservicos.controller;

import com.example.evento_microservicos.domain.Evento;
import com.example.evento_microservicos.dto.EventoDTO;
import com.example.evento_microservicos.dto.SubscricaoDto;
import com.example.evento_microservicos.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;
    @PostMapping
    public ResponseEntity<Evento> criarEvento (@RequestBody EventoDTO dto) {
        Evento evento = eventoService.criarEvento(dto);
        return new ResponseEntity<>(evento, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Evento>> listarEvento () {
        List<Evento> eventos = eventoService.listarEvento();
        return new ResponseEntity<>(eventos, HttpStatus.OK);
    }

    @GetMapping("/iraoAcontecer")
    public ResponseEntity<List<Evento>> eventosDisponiveis () {
        List<Evento> eventos = eventoService.eventosDisponiveis();
        return new ResponseEntity<>(eventos, HttpStatus.OK);
    }

    @PostMapping("/{id}/registrar")
    public void  registrarParticipante (@PathVariable String id, @RequestBody SubscricaoDto dto) {
        eventoService.inscrever(id, dto.email());
    }

}
