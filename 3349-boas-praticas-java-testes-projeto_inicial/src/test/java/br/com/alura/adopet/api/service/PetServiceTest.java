package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.CadastroPetDto;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.repository.PetRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class PetServiceTest {

    @InjectMocks
    PetService petService;

    @Mock
    private PetRepository petRepository;

    @Mock
    private CadastroPetDto dto;
    @Mock
    private Abrigo abrigo;

    @Test
    void deveriaCadastrar() {
        //Arrange
        //Act
        petService.cadastrarPet(abrigo, dto);
        //Assert
        BDDMockito.then(petRepository).should().save(new Pet(dto, abrigo));
    }

    @Test
    void deveriaRetornarTodosOsPetsDisponiveis() {
        //Arrange
        //Act
        petService.buscarPetsDisponiveis();
        //Assert
        BDDMockito.then(petRepository).should().findAllByAdotadoFalse();
    }

}