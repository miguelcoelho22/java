package com.example.evento_microservicos.domain;

import com.example.evento_microservicos.dto.EventoDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "evento")
@Table(name = "evento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private int maximoParticipantes;

    private String data;

    private String titulo;

    private String descricao;

    public Evento(EventoDTO dto) {
        this.maximoParticipantes = dto.maximoParticipantes();
        this.data = dto.data();
        this.titulo = dto.titulo();
        this.descricao = dto.descricao();
    }
}
