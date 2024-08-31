package com.example.evento_microservicos_teste.service;

import com.example.evento_microservicos_teste.domain.Evento;
import com.example.evento_microservicos_teste.domain.Subscricao;
import com.example.evento_microservicos_teste.dto.EmailDto;
import com.example.evento_microservicos_teste.dto.EventoDto;
import com.example.evento_microservicos_teste.exception.EventoException;
import com.example.evento_microservicos_teste.repository.EventoRepository;
import com.example.evento_microservicos_teste.repository.SubscricaoRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private SubscricaoRepository subscricaoRepository;

    public Evento criarEvento(EventoDto dto) {
        return eventoRepository.save(new Evento(dto));
    }

    public List<Evento> acharEventos() {
        return eventoRepository.findAll();
    }

    public @NonNull Optional<Evento> acharEventoPorId(String id) {
        return eventoRepository.findById(id);

    }

    public List<Evento> acharEventosDisponiveis() {
        return eventoRepository.acharEventosDisponiveis(LocalDateTime.now());
    }

    int contador = 0
    public void registrarParticipante(String id, String email) {
        Evento evento = eventoRepository.findById(id).orElseThrow( () -> new EventoException("evento nao encontrado"));
    if(contador > evento.getMaximoDeParticipantes()) {
        throw new EventoException("evento cheio");
    }
        Subscricao subscricao = new Subscricao(evento, email);
        subscricaoRepository.save(subscricao);

        EmailDto emailDto = new EmailDto(email, "evento", "cadastrado no evento" + evento.getNome());

        contador += 1;

    }   
}
