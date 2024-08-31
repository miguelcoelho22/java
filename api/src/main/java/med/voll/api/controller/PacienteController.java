package med.voll.api.controller;

import jakarta.persistence.Entity;
import jakarta.transaction.Transactional;
import med.voll.api.medico.DadosListagemMedico;
import med.voll.api.medico.Medico;
import med.voll.api.paciente.*;
import med.voll.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    PacienteRepository repository;
    @PostMapping
    @Transactional
    public ResponseEntity salvar(@RequestBody DadosCadastroPaciente dadosCadastroPaciente, UriComponentsBuilder uriComponentsBuilder){
        var paciente = new Paciente(dadosCadastroPaciente);
        repository.save(paciente);

        var uri = uriComponentsBuilder.path("pacientes/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(uri).body(paciente);
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemPaciente>> trazerDados(){
          var page = repository.findAllByAtivoTrue().stream().map(DadosListagemPaciente::new)
                .collect(Collectors.toList());
          return ResponseEntity.ok(page);
    }
    @PutMapping
    @Transactional
    public ResponseEntity atualizarPaciente(@RequestBody DadosAtualizacaoPaciente dados){
        var paciente = repository.getReferenceById(dados.id());
        paciente.atualizar(dados);

        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity remover(@PathVariable Long id){
        var paciente = repository.getReferenceById(id);
        paciente.remover();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var paciente = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }
}
