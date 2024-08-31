package eu.com.br.escola.service;

import eu.com.br.escola.controller.ProfessorNota;
import eu.com.br.escola.domain.Aluno;
import eu.com.br.escola.domain.AlunoDto;
import eu.com.br.escola.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {


    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno cadastrar(AlunoDto dto) {
        Aluno aluno = alunoRepository.save(new Aluno(dto));
        return aluno;

    }

    public List<Aluno> trazerDados() {
        return alunoRepository.findAll();
    }

    int contador = 0;
    public Aluno nota(ProfessorNota dto) {

        Aluno aluno = alunoRepository.getReferenceById(dto.idAluno());
        if(dto.nota() > 6) {
            contador += 1;
            if(contador == 5) {
                aluno.colocarReprovado(dto);
            }
        }
        alunoRepository.save(aluno);
        return aluno;


    }
}
