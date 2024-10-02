package com.example.crud.domain;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "universidade")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Universidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cidade;

    public Universidade(UniversidadeDto dto) {
        this.nome = dto.nome();
        this.cidade = dto.cidade();
    }
}
