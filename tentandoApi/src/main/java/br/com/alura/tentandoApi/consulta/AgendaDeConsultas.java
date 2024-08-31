package br.com.alura.tentandoApi.consulta;

import br.com.alura.tentandoApi.consulta.validacoes.ValidadorAgendamentoDeConsultas;
import br.com.alura.tentandoApi.infra.exception.ValidacaoException;
import br.com.alura.tentandoApi.medico.Medico;
import br.com.alura.tentandoApi.repository.ConsultaRepository;
import br.com.alura.tentandoApi.repository.MedicoRepository;
import br.com.alura.tentandoApi.repository.PacienteRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaDeConsultas {

    @Autowired
    private ConsultaRepository repository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private List<ValidadorAgendamentoDeConsultas> validadores;

    public void agendar(DadosAgendamentoConsulta dados) throws Exception {
        if (!pacienteRepository.existsById(dados.idPaciente())) {
            throw new ValidacaoException("paciente nao esta no banco de dados");
        }
        if(dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())){
            throw new ValidacaoException("medico nao esta no banco de dados");
        }

        validadores.forEach(v -> v.validar(dados));

        var paciente = pacienteRepository.findById(dados.idPaciente()).orElseThrow( () -> new Exception("nao ebncontraddoa"));
        var medico = escolherMedico(dados);
        var consulta = new Consulta(null, medico, paciente);

        repository.save(consulta);

    }

    private Medico escolherMedico(DadosAgendamentoConsulta dados) {
        if(dados.idMedico() != null) {
            return medicoRepository.getReferenceById(dados.idMedico());
        }

        if(dados.especialidade() == null ) {
            throw new ValidacaoException("especialidade obrigatoria quando o medico nao for escolhido");
        }

        return medicoRepository.escolherMedicoAleatorio(dados.especialidade(), dados.data());
    }
}
