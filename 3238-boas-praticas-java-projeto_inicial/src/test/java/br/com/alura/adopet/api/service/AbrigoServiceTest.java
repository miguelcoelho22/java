package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.repository.AbrigoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class AbrigoServiceTest {

    @InjectMocks
    private AbrigoService abrigoService;

    @Mock
    private AbrigoRepository abrigoRepository;



    @Test
    void teste01() {
        abrigoService.listar();
        BDDMockito.then(abrigoRepository).should().findAll();
    }

    @Test
    void teste02() {

        Abrigo abrigo = new Abrigo();
        abrigo.setNome("miguel");
        abrigo.setTelefone("37998644777");
        abrigo.setEmail("mgieul@gmail.com");


        BDDMockito.given(abrigoRepository.existsByNomeOrTelefoneOrEmail(abrigo.getNome(), abrigo.getTelefone(), abrigo.getEmail()))
                .willReturn(true);


        Assertions.assertThrows(ValidacaoException.class, () -> abrigoService.cadastrar(abrigo));


    }

    @Test
    void teste03() {

        Abrigo abrigo = new Abrigo();
        abrigo.setNome("miguel");
        abrigo.setTelefone("37998644777");
        abrigo.setEmail("mgieul@gmail.com");

        abrigoService.cadastrar(abrigo);

        BDDMockito.then(abrigoRepository).should().save(abrigo);


    }

}