package med.voll.api.repository;

import med.voll.api.paciente.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    List<Paciente> findAllByAtivoTrue();

    @Query("select p.ativo from paciente p where p.id = :idPaciente")
    boolean findAtivoById(Long idPaciente);
}
