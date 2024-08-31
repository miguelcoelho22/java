package br.com.alura.tentandoApi.controller;

import br.com.alura.tentandoApi.consulta.AgendaDeConsultas;
import br.com.alura.tentandoApi.consulta.DadosDetalhamentoConsulta;
import br.com.alura.tentandoApi.consulta.DadosAgendamentoConsulta;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consultas")
public class ConsultaController {

    @Autowired
    private AgendaDeConsultas agenda;
    @PostMapping
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsulta dados) throws Exception {
        agenda.agendar(dados);

        return ResponseEntity.ok(new DadosDetalhamentoConsulta(null, null, null, null));
    }
}
