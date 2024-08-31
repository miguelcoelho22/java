package med.voll.api.consulta.validacao;

import med.voll.api.consulta.DadosAgendamentoConsulta;
import med.voll.api.infra.exception.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidadosHorarioFuncionamentoClinica implements ValidadorAgendamentoDeConsultas{

    public void validar(DadosAgendamentoConsulta dados) {
        var dataCosulta = dados.data();

        var domingo = dataCosulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAbertura = dataCosulta.getHour() < 7;
        var depoisDoEncerramento = dataCosulta.getHour() > 18;


        if (domingo || antesDaAbertura || depoisDoEncerramento) {
            throw new ValidacaoException("consulta fora do horario de funcionamento da clinica");
        }
    }
}
