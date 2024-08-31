package eu.com.br.escola.controller;

import eu.com.br.escola.domain.Aluno;
import eu.com.br.escola.domain.Professor;
import eu.com.br.escola.domain.ProfessorDto;
import eu.com.br.escola.service.AlunoService;
import eu.com.br.escola.service.ProfessorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService service;

    @Autowired
    private AlunoService alunoService;
    @PostMapping
    @Transactional
    public ResponseEntity<Professor> salvar(@RequestBody ProfessorDto dto) {
        Professor professor = service.salvar(dto);
        return new ResponseEntity<>(professor, HttpStatus.CREATED);
    }

    @PostMapping("/nota")
    @Transactional
    public ResponseEntity<Aluno> nota(@RequestBody ProfessorNota dto){
        Aluno aluno = alunoService.nota(dto);
        return new ResponseEntity<>(aluno, HttpStatus.OK);
    }
}
