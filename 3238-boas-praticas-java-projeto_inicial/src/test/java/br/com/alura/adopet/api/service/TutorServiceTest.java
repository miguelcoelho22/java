package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Tutor;
import br.com.alura.adopet.api.repository.TutorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TutorServiceTest {

    @InjectMocks
    private TutorService tutorService;

    @Mock
    private TutorRepository tutorRepository;

    @Mock
    private Tutor tutor;

    @Test
    void teste01() {
        BDDMockito.given(tutorRepository.existsByTelefoneOrEmail(tutor.getTelefone(), tutor.getNome()))
                .willReturn(true);


        Assertions.assertThrows(ValidacaoException.class, () -> tutorService.cadastrar(tutor));
    }

    @Test
    void teste02() {
        BDDMockito.given(tutorRepository.existsByTelefoneOrEmail(tutor.getTelefone(), tutor.getNome()))
                .willReturn(false);


        Assertions.assertDoesNotThrow(() -> tutorService.cadastrar(tutor));
        BDDMockito.then(tutorRepository).should().save(tutor);
    }

}