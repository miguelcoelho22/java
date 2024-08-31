package eu.com.br.escola.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "turmas")
@Table(name = "turmas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private AnoTurma anoTurma;

    @Enumerated(EnumType.STRING)
    private Horario horarioTurma;

    @ManyToOne
    private Professor professor;

    @OneToMany
    private List<Aluno> aluno;


}
