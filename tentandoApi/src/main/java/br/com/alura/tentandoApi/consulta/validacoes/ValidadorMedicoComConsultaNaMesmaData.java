package br.com.alura.tentandoApi.consulta.validacoes;

import br.com.alura.tentandoApi.consulta.Consulta;
import br.com.alura.tentandoApi.consulta.DadosAgendamentoConsulta;
import br.com.alura.tentandoApi.infra.exception.ValidacaoException;
import br.com.alura.tentandoApi.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoComConsultaNaMesmaData implements ValidadorAgendamentoDeConsultas{

    @Autowired
    private ConsultaRepository repository;
    public void validar(DadosAgendamentoConsulta dados) {
        var medicoConsultaMesmaData = repository.existsByMedicoIdAndData(dados.idMedico(), dados.data());
        if(medicoConsultaMesmaData) {
            throw new ValidacaoException("medico ja possui outra consulta nessa data");
        }
    }
}
