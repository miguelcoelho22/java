package com.example.adopet_meu_projeto.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "estoque")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantidade;

    @OneToOne
    private Produto produto;

    public Estoque(Produto produto, Integer integer) {
        this.produto = produto;
        this.quantidade = integer;
    }
}
