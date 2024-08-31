package eu.com.br.escola.service;

import eu.com.br.escola.controller.ProfessorNota;
import eu.com.br.escola.domain.Aluno;
import eu.com.br.escola.domain.Professor;
import eu.com.br.escola.domain.ProfessorDto;
import eu.com.br.escola.domain.Turma;
import eu.com.br.escola.repository.AlunoRepository;
import eu.com.br.escola.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;



    public Professor salvar(ProfessorDto dto) {
        return professorRepository.save(new Professor(dto));
    }

}
