package br.com.alura.screenmatchfrases.service;

import br.com.alura.screenmatchfrases.DTO.FraseDTO;
import br.com.alura.screenmatchfrases.model.Frase;
import br.com.alura.screenmatchfrases.repository.FraseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FraseService {
    @Autowired
    FraseRepository repositorio;
    public FraseDTO obterFraseAleatoria() {
        Frase frase = repositorio.buscaAleatoria();
        return new FraseDTO(frase.getTitulo(), frase.getFrase(), frase.getPersonagem(), frase.getPoster());
    }
}
