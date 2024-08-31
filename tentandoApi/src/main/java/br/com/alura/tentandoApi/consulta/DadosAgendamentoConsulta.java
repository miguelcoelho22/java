package br.com.alura.tentandoApi.consulta;

import br.com.alura.tentandoApi.medico.Especialidade;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamentoConsulta(
        Long idMedico,
        @NotNull
        Long idPaciente,


        LocalDateTime data,
        Especialidade especialidade) {
}
