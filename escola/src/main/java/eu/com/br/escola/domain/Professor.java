package eu.com.br.escola.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "professor")
@Table(name = "professor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;


    public Professor(ProfessorDto dto) {
        this.nome = dto.nome();
        this.especialidade = dto.especialidade();
    }
}
