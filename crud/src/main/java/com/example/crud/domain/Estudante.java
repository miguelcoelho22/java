package com.example.crud.domain;


import jakarta.persistence.*;
import lombok.*;

@Table(name = "estudante")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Estudante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private AreaGraducao areaGraducao;

    @ManyToOne
    private Universidade universidade;

    public Estudante(String nome, AreaGraducao areaGraducao, Universidade universidade) {
        this.nome = nome;
        this.areaGraducao = areaGraducao;
        this.universidade = universidade;
    }
}
