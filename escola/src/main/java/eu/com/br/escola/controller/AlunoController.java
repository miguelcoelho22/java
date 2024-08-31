package eu.com.br.escola.controller;

import eu.com.br.escola.domain.Aluno;
import eu.com.br.escola.domain.AlunoDto;
import eu.com.br.escola.service.AlunoService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService service;

    @PostMapping
    @Transactional
    public ResponseEntity<Aluno> cadastroALuno(@RequestBody AlunoDto dto) {
        Aluno aluno = service.cadastrar(dto);
        return new ResponseEntity<>(aluno, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> trazerDados() {
        List<Aluno> aluno = service.trazerDados();
        return new ResponseEntity<>(aluno, HttpStatus.OK);
    }
}
