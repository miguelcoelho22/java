package br.com.alura.adopet.api.repository;

import br.com.alura.adopet.api.model.Adocao;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.model.StatusAdocao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdocaoRepository extends JpaRepository<Adocao, Long> {

    Boolean existsByPetIdAndStatus(Long idPet, StatusAdocao status);

    Boolean existsByTutorIdAndStatus(Long idTutor, StatusAdocao statusAdocao);

    Integer countByTutorIdAndStatus(Long aLong, StatusAdocao statusAdocao);
}
