package br.com.alura.tentandoApi.consulta.validacoes;

import br.com.alura.tentandoApi.consulta.DadosAgendamentoConsulta;
import br.com.alura.tentandoApi.infra.exception.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidadorHorarioFuncionamentoClinica implements ValidadorAgendamentoDeConsultas{
    public void validar(DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();

        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAbertura = dataConsulta.getHour() < 7;
        var depoisDaAbertura =  dataConsulta.getHour() > 18;

        if(domingo || antesDaAbertura || depoisDaAbertura) {
            throw new ValidacaoException("Consulta fora do horario de funcionamento Da clinica");
        }
    }
}
