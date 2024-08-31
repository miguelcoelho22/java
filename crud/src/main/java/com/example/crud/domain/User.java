package com.example.crud.domain;

import com.example.crud.domain.dto.UserDto;
import com.example.crud.domain.dto.UserDtoEditar;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "usuarios")
@Entity(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private Sexo sex;

    private String phone;

    private String age;

    public User(UserDto dto) {
        this.nome = dto.name();
        this.sex = dto.sex();
        this.phone = dto.phone();
        this.age = dto.age();
    }

    public void editar(UserDtoEditar dtoEditar) {
        if(dtoEditar.name() != null) {
            this.nome = dtoEditar.name();
        }
        if(dtoEditar.age() != null) {
            this.age = dtoEditar.age();
        }
        if(dtoEditar.sex() != null) {
            this.sex = dtoEditar.sex();
        }
        if(dtoEditar.phone() != null) {
            this.phone = dtoEditar.phone();
        }
    }
}
