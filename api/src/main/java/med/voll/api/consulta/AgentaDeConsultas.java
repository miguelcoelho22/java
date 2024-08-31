package med.voll.api.consulta;

import med.voll.api.consulta.validacao.ValidadorAgendamentoDeConsultas;
import med.voll.api.infra.exception.ValidacaoException;
import med.voll.api.medico.DadosDetalhamentoMedico;
import med.voll.api.medico.Medico;
import med.voll.api.repository.ConsultaRepository;
import med.voll.api.repository.MedicoRepository;
import med.voll.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentaDeConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private List<ValidadorAgendamentoDeConsultas> validador;

    public DadosDetalhamentoConsulta agendar(DadosAgendamentoConsulta dados) {
        if( !pacienteRepository.existsById(dados.idPaciente())) {
            throw new ValidacaoException("id paciente nao encontrado");
        }
        if( dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())){
            throw new ValidacaoException("id medico nao encontrado");
        }

        validador.forEach(v -> v.validar(dados));

        var medico = escolherMedico(dados);

        if(medico == null) {
            throw new ValidacaoException("nao possui nenhum medico disponivel");
        }
        var paciente = pacienteRepository.findById(dados.idPaciente()).get();
        var consulta = new Consulta(null,medico, paciente, dados.data(), null);
        consultaRepository.save(consulta);

        return new DadosDetalhamentoConsulta(consulta);
    }

    private Medico escolherMedico(DadosAgendamentoConsulta dados) {
        if(dados.idMedico() != null) {
            return medicoRepository.getReferenceById(dados.idMedico());
        }
        if (dados.especialidade() == null) {
            throw new ValidacaoException("especialidade é obrigatoria quando o medico nao for escolhido");
        }

        return medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(), dados.data());
    }

    public void cancelar(DadosCancelamentoConsulta dados) {
        if (!consultaRepository.existsById(dados.idConsulta())) {
            throw new ValidacaoException("Id da consulta informado não existe!");
        }

        var consulta = consultaRepository.getReferenceById(dados.idConsulta());
        consulta.cancelar(dados.motivo());
    }
}
