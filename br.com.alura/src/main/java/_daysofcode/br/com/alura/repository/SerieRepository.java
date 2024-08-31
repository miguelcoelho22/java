package _daysofcode.br.com.alura.repository;

import _daysofcode.br.com.alura.serie.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository<Serie, Long> {
}
