package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.CadastroAbrigoDto;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.repository.AbrigoRepository;
import br.com.alura.adopet.api.repository.PetRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AbrigoServiceTest {

    @InjectMocks
    AbrigoService abrigoService;

    @Mock
    private CadastroAbrigoDto dto;

    @Mock
    private AbrigoRepository abrigoRepository;

    @Mock
    private PetRepository petRepository;

    @Mock
    Abrigo abrigo;


    @Test
    void DeveriaListarTodosOsAbrigos() {
        //Arrange
        abrigoService.listar();
        //Act
        BDDMockito.then(abrigoRepository).should().findAll();
        //Assert
    }

    @Test
    void deveriaChamarListaDePetsDoAbrigoAtravesDoNome(){
        //Arrange
        String nome = "miau";
        BDDMockito.given(abrigoRepository.findByNome(nome)).willReturn(Optional.of(abrigo));
        //Act
        abrigoService.listarPetsDoAbrigo(nome);
        //Assert
        BDDMockito.then(petRepository).should().findByAbrigo(abrigo);
    }

    @Test
    void jaCadastrado() {
        //Arrange
        this.dto = new CadastroAbrigoDto("miguel", "37998644777", "miguel@gmail");
        BDDMockito.given(abrigoRepository.existsByNomeOrTelefoneOrEmail(dto.nome(), dto.telefone(), dto.email()))
                .willReturn(true);
        //Act

        //Assert
        Assertions.assertThrows(ValidacaoException.class, () -> abrigoService.cadatrar(dto));
    }

}