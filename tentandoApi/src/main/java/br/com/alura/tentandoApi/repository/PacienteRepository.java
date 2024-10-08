package br.com.alura.tentandoApi.repository;

import br.com.alura.tentandoApi.paciente.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    @Query("""
            select p.ativo from Paciente p
            where
            p.id = :id
            """)
    Boolean findAtivoById(Long id);
}
