package _daysofcode.br.com.alura.serie;

import jakarta.persistence.*;

@Table(name = "series")
@Entity(name = "serie")
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String ano;

    @Enumerated(value = EnumType.STRING)
    private Categoria categoria;

    public Serie(){}
    public Serie(SerieDto dto) {
        this.titulo = dto.titulo();
        this.ano = dto.ano();
    }
}
