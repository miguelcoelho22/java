package com.example.evento_microservicos.service;

import com.example.evento_microservicos.domain.Evento;
import com.example.evento_microservicos.domain.Subscricao;
import com.example.evento_microservicos.dto.EmailDTO;
import com.example.evento_microservicos.dto.EventoDTO;
import com.example.evento_microservicos.exception.EventoCheioException;
import com.example.evento_microservicos.exception.EventoException;
import com.example.evento_microservicos.repository.EventoRepository;
import com.example.evento_microservicos.repository.SubscricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private SubscricaoRepository subscricaoRepository;

    @Autowired
    private EmailServiceClient emailServiceClient;
    public Evento criarEvento (EventoDTO dto) {
        return eventoRepository.save(new Evento(dto));
    }

    public List<Evento> listarEvento() {
        return eventoRepository.findAll();
    }

    public List<Evento> eventosDisponiveis() {
        return eventoRepository.acharEventosDisponiveis(LocalDateTime.now());
    }

    int contador = 0;
    public void inscrever(String id, String email) {

        Evento evento = eventoRepository.findById(id).orElseThrow(() -> new EventoException("evento nao encontrado"));

        if(contador > evento.getMaximoParticipantes()) {
            throw new EventoCheioException("evento cheio");
        }

        Subscricao subscricao = new Subscricao(email, evento);
        subscricaoRepository.save(subscricao);

        EmailDTO emailDTO = new EmailDTO(email, "evento cadastrado", "voce foi cadastrado no evento" + evento.getTitulo());
        emailServiceClient.mandarEmail(emailDTO);


        contador += 1;

    }
}
