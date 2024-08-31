package br.com.alura.oficina.mecanima.repository;

import br.com.alura.oficina.mecanima.barbeiro.Barbeiro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BarbeiroRepository extends JpaRepository<Barbeiro, Long> {
    List<Barbeiro> findAllByAtivoTrue();

}
