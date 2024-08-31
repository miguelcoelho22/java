package br.com.alura.tentandoApi.consulta.validacoes;

import br.com.alura.tentandoApi.consulta.DadosAgendamentoConsulta;
import br.com.alura.tentandoApi.infra.exception.ValidacaoException;
import br.com.alura.tentandoApi.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoDeConsultas{

    @Autowired
    private MedicoRepository repository;
    public void validar(DadosAgendamentoConsulta dados) {
        if(dados.idMedico() == null) {
            return;
        }

        var medicoEstaAtivo = repository.findAtivoById(dados.idMedico());

        if(!medicoEstaAtivo) {
            throw new ValidacaoException("consulta nao pode ser agendada com medico inativo");
        }
    }
}
