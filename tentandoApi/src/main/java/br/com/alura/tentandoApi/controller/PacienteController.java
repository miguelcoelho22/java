package br.com.alura.tentandoApi.controller;

import br.com.alura.tentandoApi.paciente.DadosCadastroPaciente;
import br.com.alura.tentandoApi.paciente.Paciente;
import br.com.alura.tentandoApi.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity salvar(@RequestBody @Valid DadosCadastroPaciente dados) {
        var paciente = new Paciente(dados);
        repository.save(paciente);

        return ResponseEntity.ok(paciente);


    }
}
