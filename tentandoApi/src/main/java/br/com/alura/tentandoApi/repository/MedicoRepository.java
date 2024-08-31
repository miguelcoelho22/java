package br.com.alura.tentandoApi.repository;

import br.com.alura.tentandoApi.medico.Especialidade;
import br.com.alura.tentandoApi.medico.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    List<Medico> findAllByAtivoTrue();


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
    Medico escolherMedicoAleatorio(Especialidade especialidade, LocalDateTime data);

    @Query("""
            select m.ativo from Medico m
            where
            m.id = :id
            """)
    Boolean findAtivoById(Long id);

}
