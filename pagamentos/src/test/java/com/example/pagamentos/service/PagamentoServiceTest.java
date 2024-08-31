package com.example.pagamentos.service;

import com.example.pagamentos.repository.PagamentoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Pageable;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PagamentoServiceTest {

    @InjectMocks
    private PagamentoService service;

    private Pageable paginacao;

    @Mock
    private PagamentoRepository repository;

    @Test
    void teste01() {
        //arrange
        //act
        service.obterTodos(paginacao);
        //assert
        BDDMockito.then(repository).should().findAll(paginacao);
    }

}