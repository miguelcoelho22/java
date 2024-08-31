package br.com.alura.oficina.mecanima.repository;

import br.com.alura.oficina.mecanima.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
