package com.example.adopet_meu_projeto.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;

@Entity
@Table(name = "pedidos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
    private ArrayList<ItemPedido> itemPedido = new ArrayList<>();
}
