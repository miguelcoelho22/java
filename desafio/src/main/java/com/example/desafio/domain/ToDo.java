package com.example.desafio.domain;

import com.example.desafio.controller.ToDoDto;
import com.example.desafio.dto.ToDoDtoEditar;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "toDo")
@Table(name = "toDo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    private String realizado;

    private String prioridade;

    public ToDo(ToDoDto dto) {
        this.nome = dto.nome();
        this.descricao = dto.descricao();
        this.realizado = dto.realizado();
        this.prioridade = dto.prioridade();
    }

    public void editar(ToDoDtoEditar dto) {
        if(dto.nome() != null) {
            this.nome = dto.nome();
        }
        if(dto.descricao() != null) {
            this.descricao = dto.descricao();
        }
        if(dto.realizado() != null) {
            this.realizado = dto.realizado();
        }
        if(dto.prioridade() != null) {
            this.prioridade = dto.prioridade();
        }
    }
}
