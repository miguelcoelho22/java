package br.com.alura.oficina.mecanima.controller;

import br.com.alura.oficina.mecanima.barbeiro.Barbeiro;
import br.com.alura.oficina.mecanima.barbeiro.DadosAtualizacaoBarbeiro;
import br.com.alura.oficina.mecanima.barbeiro.DadosCadastroBarbeiro;
import br.com.alura.oficina.mecanima.barbeiro.DadosListagemBarbeiro;
import br.com.alura.oficina.mecanima.repository.BarbeiroRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("barbeiros")
public class BarbeiroController {

    @Autowired
    private BarbeiroRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity salvar(@RequestBody @Valid DadosCadastroBarbeiro dados ){
        var barbeiro = new Barbeiro(dados);
        repository.save(barbeiro);

        return ResponseEntity.ok(new DadosListagemBarbeiro(barbeiro));
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemBarbeiro>> enviar() {
        var dto = repository.findAllByAtivoTrue().stream().map(DadosListagemBarbeiro::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    @Transactional
    public ResponseEntity editar(@RequestBody @Valid DadosAtualizacaoBarbeiro dados) {
        var barbeiro = repository.getReferenceById(dados.id());
        barbeiro.mudarInformacoes(dados);

        return  ResponseEntity.ok(new DadosListagemBarbeiro(barbeiro));


    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var barbeiro = repository.getReferenceById(id);

        repository.delete(barbeiro);
        return ResponseEntity.noContent().build();
    }
}
