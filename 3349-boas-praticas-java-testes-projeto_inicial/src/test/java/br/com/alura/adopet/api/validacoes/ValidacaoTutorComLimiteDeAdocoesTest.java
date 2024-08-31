package br.com.alura.adopet.api.validacoes;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDto;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.StatusAdocao;
import br.com.alura.adopet.api.repository.AdocaoRepository;
import br.com.alura.adopet.api.repository.TutorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;


@ExtendWith(MockitoExtension.class)
class ValidacaoTutorComLimiteDeAdocoesTest {


    @InjectMocks
    private ValidacaoTutorComLimiteDeAdocoes validar;

    @Mock
    private AdocaoRepository adocaoRepository;

    @Mock
    private SolicitacaoAdocaoDto dto;

    @Test
    void tutorNaoChegouNoLimiteDeAdocao() {
        //Arrange
        BDDMockito.given(adocaoRepository.countByTutorIdAndStatus(dto.idTutor(), StatusAdocao.APROVADO))
                .willReturn(1);
        //Act

        //Assert
        Assertions.assertDoesNotThrow(() -> validar.validar(dto));

    }

    @Test
    void tutorChegouNoLimiteDeAdocao() {
        //Arrange
        BDDMockito.given(adocaoRepository.countByTutorIdAndStatus(dto.idTutor(), StatusAdocao.APROVADO))
                .willReturn(5);
        //Act

        //Assert
        Assertions.assertThrows(ValidacaoException.class, () -> validar.validar(dto));

    }

}