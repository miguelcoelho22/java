package br.com.alura.tentandoApi.controller;

import br.com.alura.tentandoApi.medico.DadosAtualizacaoMedico;
import br.com.alura.tentandoApi.medico.DadosCadastroMedico;
import br.com.alura.tentandoApi.medico.DadosListagemMedico;
import br.com.alura.tentandoApi.medico.Medico;
import br.com.alura.tentandoApi.repository.MedicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    MedicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico dados, UriComponentsBuilder uriComponentsBuilder){
        var medico = new Medico(dados);

        repository.save(medico);

        var uri = uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(dados);
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemMedico>> listar(){
        var list = repository.findAllByAtivoTrue().stream().map(DadosListagemMedico::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(list);

    }

    @PutMapping
    @Transactional
    public ResponseEntity editar(@RequestBody @Valid DadosAtualizacaoMedico dados){
        var medico = repository.getReferenceById(dados.id());

        medico.mudarPorId(dados);

        return ResponseEntity.ok(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.colocarInativo();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity expecifico(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosListagemMedico(medico));


    }

}
