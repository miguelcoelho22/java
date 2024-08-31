package med.voll.api.repository;

import med.voll.api.medico.Especialidade;
import med.voll.api.medico.Medico;
import org.antlr.v4.runtime.tree.pattern.ParseTreePattern;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findAllByAtivoTrue(Pageable paginacao);

    @Query("""
          select m from Medico m
          where
          m.ativo = true
          and
          m.especialidade = :especialidade
          and
          m.id not in(
            select c.medico.id from Consulta c
            where
            c.data = :data
          )
          order by rand()
          limit 1
            """)
    Medico escolherMedicoAleatorioLivreNaData(Especialidade especialidade, LocalDateTime data);

   @Query("select m.ativo from Medico m where m.id = :idMedico ")
   Boolean findAtivoById(Long idMedico);

}
