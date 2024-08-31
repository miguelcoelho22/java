package eu.com.br.escola.domain;


import eu.com.br.escola.controller.ProfessorNota;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "alunos")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String telefone;

    private String email;

    private Boolean aprovado;

    @Enumerated(EnumType.STRING)
    private Horario horario;

    private Integer nota;

    public Aluno(AlunoDto dto) {
        this.nome = dto.nome();
        this.telefone = dto.telefone();
        this.email = dto.email();
        this.horario = dto.horario();
        this.aprovado = true;
    }

    public void colocarReprovado(ProfessorNota dto) {
        this.aprovado = false;
        this.nota = dto.nota();
    }
}
