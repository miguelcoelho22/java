package br.com.alura.adopet.api.repository;

import br.com.alura.adopet.api.model.Adocao;
import br.com.alura.adopet.api.model.StatusAdocao;
import br.com.alura.adopet.api.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdocaoRepository extends JpaRepository<Adocao, Long> {

    boolean existsByPetIdAndStatus(Long idPet, StatusAdocao status);

    Integer countByTutorIdAndStatus(Long aLong, StatusAdocao statusAdocao);

    Boolean existsByTutorIdAndStatus(Long aLong, StatusAdocao statusAdocao);


}
