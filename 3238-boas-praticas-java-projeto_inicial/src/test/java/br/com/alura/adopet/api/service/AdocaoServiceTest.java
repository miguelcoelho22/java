package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDto;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Adocao;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.model.Tutor;
import br.com.alura.adopet.api.repository.AdocaoRepository;
import br.com.alura.adopet.api.repository.PetRepository;
import br.com.alura.adopet.api.repository.TutorRepository;
import br.com.alura.adopet.api.validacoes.ValidacaoPetComAdocaoEmAndamento;
import br.com.alura.adopet.api.validacoes.ValidacaoPetDisponivel;
import br.com.alura.adopet.api.validacoes.Validacoes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class AdocaoServiceTest {

    @InjectMocks
    private AdocaoService adocaoService;


    private SolicitacaoAdocaoDto dto;

    @Mock
    private Tutor tutor;

    @Mock
    private AdocaoRepository repository;

    @Mock
    private Pet pet;

    @Captor
    private ArgumentCaptor<Adocao> argumentCaptor;

    @Mock
    private PetRepository petRepository;

    @Mock
    private TutorRepository tutorRepository;

    @Spy
    private List<Validacoes> validacoes = new ArrayList<>();

    @Mock
    private ValidacaoPetDisponivel validacaoPetDisponivel;

    @Mock
    private ValidacaoPetComAdocaoEmAndamento validacaoPetComAdocaoEmAndamento;

    @Mock
    private Abrigo abrigo;

    @Mock
    private EmailService emailService;


    @Test
    void teste01() {
        this.dto = new SolicitacaoAdocaoDto(1L, 2L,"motivo");

        BDDMockito.given(petRepository.getReferenceById(dto.idPet())).willReturn(pet);
        BDDMockito.given(tutorRepository.getReferenceById(dto.idTutor())).willReturn(tutor);
        BDDMockito.given(pet.getAbrigo()).willReturn(abrigo);

        adocaoService.solicitar(dto);

        BDDMockito.then(repository).should().save(argumentCaptor.capture());

        Adocao adocao = argumentCaptor.getValue();

        Assertions.assertEquals(pet, adocao.getPet());
        Assertions.assertEquals(tutor, adocao.getTutor());
        Assertions.assertEquals(dto.motivo(), adocao.getMotivo());

    }

    @Test
    void teste02() {
        this.dto = new SolicitacaoAdocaoDto(1L, 2L,"motivo");

        BDDMockito.given(petRepository.getReferenceById(dto.idPet())).willReturn(pet);
        BDDMockito.given(tutorRepository.getReferenceById(dto.idTutor())).willReturn(tutor);
        BDDMockito.given(pet.getAbrigo()).willReturn(abrigo);

        validacoes.add(validacaoPetDisponivel);
        validacoes.add(validacaoPetComAdocaoEmAndamento);

        adocaoService.solicitar(dto);

        BDDMockito.then(validacaoPetDisponivel).should().validar(dto);
        BDDMockito.then(validacaoPetComAdocaoEmAndamento).should().validar(dto);








    }
}