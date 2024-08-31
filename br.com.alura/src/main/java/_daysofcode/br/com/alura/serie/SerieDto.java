package _daysofcode.br.com.alura.serie;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SerieDto(@JsonAlias("Title") String titulo, @JsonAlias("Year") String ano) {
}
