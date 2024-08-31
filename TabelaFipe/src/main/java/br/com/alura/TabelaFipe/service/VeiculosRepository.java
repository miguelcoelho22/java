package br.com.alura.TabelaFipe.service;


import br.com.alura.TabelaFipe.model.Veiculos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculosRepository extends JpaRepository<Veiculos, Long> {
}
