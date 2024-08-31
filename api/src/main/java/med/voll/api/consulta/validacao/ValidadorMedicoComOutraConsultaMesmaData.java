package med.voll.api.consulta.validacao;

import med.voll.api.consulta.DadosAgendamentoConsulta;
import med.voll.api.infra.exception.ValidacaoException;
import med.voll.api.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoComOutraConsultaMesmaData implements ValidadorAgendamentoDeConsultas{

    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {

        var medicoMesmaData = repository.existsByMedicoIdAndData(dados.idMedico(), dados.data());

        if(medicoMesmaData) {
            throw new ValidacaoException("medico ja possui consulta no mesmo horario e data");
        }
    }

}
