package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Tutor;
import br.com.alura.adopet.api.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TutorService {
    @Autowired
    private TutorRepository tutorRepository;
    public void cadastrar(Tutor tutor) {
        Boolean jaCadastrado  = tutorRepository.existsByTelefoneOrEmail(tutor.getTelefone(), tutor.getEmail());

        if(jaCadastrado) {
            throw new ValidacaoException("tutor ja cadastrado anteriormente");
        }

        String palavra = "oa";

        palavra.toUpperCase();

        tutorRepository.save(tutor);
    }

    public void atualizar(Tutor tutor) {
        tutorRepository.findById(tutor.getId());
    }
}
