package med.voll.api.consulta;

import med.voll.api.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletarConsultas {
    @Autowired
    private ConsultaRepository repository;
    public void deletar(Long id){


        var consulta = repository.getReferenceById(id);

        repository.delete(consulta);
    }
}
