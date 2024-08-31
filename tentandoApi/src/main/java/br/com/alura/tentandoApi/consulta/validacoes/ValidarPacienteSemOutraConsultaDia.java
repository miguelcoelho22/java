package br.com.alura.tentandoApi.consulta.validacoes;

import br.com.alura.tentandoApi.consulta.DadosAgendamentoConsulta;
import br.com.alura.tentandoApi.infra.exception.ValidacaoException;
import br.com.alura.tentandoApi.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarPacienteSemOutraConsultaDia implements ValidadorAgendamentoDeConsultas{

    @Autowired
    private ConsultaRepository repository;
    public void validar(DadosAgendamentoConsulta dados){
        var primeiroHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);
        var pacienteConsultaMesmoDia = repository.existsByPacienteIdAndDataBetween(dados.idPaciente(), primeiroHorario, ultimoHorario);
        if(pacienteConsultaMesmoDia) {
            throw new ValidacaoException("paciente ja possui consulta nesse dia");
        }
    }

}
