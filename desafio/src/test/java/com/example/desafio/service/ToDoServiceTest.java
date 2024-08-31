package com.example.desafio.service;

import com.example.desafio.controller.ToDoDto;
import com.example.desafio.domain.ToDo;
import com.example.desafio.repository.ToDoRepository;
import org.glassfish.jaxb.core.v2.TODO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ToDoServiceTest {

    @InjectMocks
    private ToDoService service;
    @Mock
    private ToDoDto dto;
    @Mock
    private ToDoRepository repository;

    @Test
    void salvar(){
        //arrange
        //act

        service.criar(dto);
        //assert
        BDDMockito.then(repository).should().save(new ToDo(dto));
    }

}