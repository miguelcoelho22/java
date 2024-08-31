package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.AbrigoDto;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.repository.AbrigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AbrigoService {

    @Autowired
    private AbrigoRepository abrigoRepository;

    public void cadastrar(Abrigo abrigo) {
        Boolean jaCadastrado = abrigoRepository.existsByNomeOrTelefoneOrEmail(abrigo.getNome(), abrigo.getTelefone(), abrigo.getEmail());
        if(jaCadastrado) {
            throw new ValidacaoException("Dados ja cadastrado anteriormente");
        }

        abrigoRepository.save(abrigo);
    }

    public List<AbrigoDto> listar() {
        return abrigoRepository.findAll()
                .stream().map(AbrigoDto::new)
                .collect(Collectors.toList());
    }
}
