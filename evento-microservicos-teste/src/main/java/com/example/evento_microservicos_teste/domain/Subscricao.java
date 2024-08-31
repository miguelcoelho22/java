package com.example.evento_microservicos_teste.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "subscricao")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Subscricao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Evento evento;

    private String email;

    public Subscricao(Evento evento, String email) {
        this.evento = evento;
        this.email = email;
    }
}
