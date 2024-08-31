package com.example.evento_microservicos_teste.domain;

import com.example.evento_microservicos_teste.dto.EventoDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "eventos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String nome;

    private String descricao;

    private String data;

    private int maximoDeParticipantes;

    public Evento(EventoDto dto) {
        this.nome = dto.nome();
        this.data = dto.data();
        this.descricao = dto.descricao();
        this.maximoDeParticipantes = dto.quantidadeMaxima();
    }
}
