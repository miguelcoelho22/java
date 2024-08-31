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
import br.com.alura.adopet.api.validacoes.ValidacaoSolicitacaoAdocao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class AdocaoServiceTest {

        @InjectMocks
        private AdocaoService adocaoService;

        @Spy
        private List<ValidacaoSolicitacaoAdocao> validacoes = new ArrayList<>();

        @Mock
        private ValidacaoPetDisponivel validacao01;

        @Mock
        private ValidacaoPetComAdocaoEmAndamento validacao02;



        @Mock
        private TutorRepository tutorRepository;
        @Mock
        private PetRepository petRepository;
        @Mock
        private AdocaoRepository repository;

        @Mock
        private Abrigo abrigo;

        @Mock
        private Tutor tutor;

        @Mock
        private Adocao adocao;

        @Mock
        private Pet pet;


        private SolicitacaoAdocaoDto dto;

        @Captor
        private ArgumentCaptor<Adocao> adocaoCaptor;

        @Mock
        private EmailService emailService;

        @Test
        void cenario01(){
            //arrange
            this.dto = new SolicitacaoAdocaoDto(2l, 3l, "motivo qualquer");
            BDDMockito.given(petRepository.getReferenceById(dto.idPet())).willReturn(pet);
            BDDMockito.given(tutorRepository.getReferenceById(dto.idTutor())).willReturn(tutor);
            BDDMockito.given(pet.getAbrigo()).willReturn(abrigo);
            //act
            adocaoService.solicitar(dto);

            //assert
            BDDMockito.then(repository).should().save(adocaoCaptor.capture());
            Adocao adocaoSalva = adocaoCaptor.getValue();
            Assertions.assertEquals(pet, adocaoSalva.getPet());
            Assertions.assertEquals(tutor, adocaoSalva.getTutor());
            Assertions.assertEquals(dto.motivo(), adocaoSalva.getMotivo());

        }

    @Test
    void cenario02(){
        //arrange
        this.dto = new SolicitacaoAdocaoDto(2l, 3l, "motivo qualquer");
        BDDMockito.given(petRepository.getReferenceById(dto.idPet())).willReturn(pet);
        BDDMockito.given(tutorRepository.getReferenceById(dto.idTutor())).willReturn(tutor);
        BDDMockito.given(pet.getAbrigo()).willReturn(abrigo);

        validacoes.add(validacao01);
        validacoes.add(validacao02);
        //act
        adocaoService.solicitar(dto);
        //assert
        BDDMockito.then(validacao01).should().validar(dto);
        BDDMockito.then(validacao02).should().validar(dto);


    }
}