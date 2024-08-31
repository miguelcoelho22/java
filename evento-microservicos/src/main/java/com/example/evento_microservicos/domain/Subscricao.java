package com.example.evento_microservicos.domain;

import com.example.evento_microservicos.dto.SubscricaoDto;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "subscricao")
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


    public Subscricao(String email, Evento evento) {
        this.email = email;
        this.evento = evento;
    }
}
