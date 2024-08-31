package _daysofcode.br.com.alura.serie;

import com.fasterxml.jackson.annotation.JsonAlias;

public record NomeSerie(@JsonAlias("Title") String titulo) {
}
