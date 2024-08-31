package br.com.alura.adopet.api.controller;

import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.service.AbrigoService;
import br.com.alura.adopet.api.service.PetService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class AbrigoControllerTest {



    @Mock
    private AbrigoService abrigoService;

    @Mock
    private PetService petService;

    @Autowired
    private MockMvc mvc;

    @Test
    void deveriaDevolver200ListarAbrigos() throws Exception {
        //Act
        MockHttpServletResponse response = mvc.perform(MockMvcRequestBuilders.get("/abrigos"))
                        .andReturn().getResponse();
        //Assert
        Assertions.assertEquals(200, response.getStatus());
    }

    @Test
    void deveriaDevolverCodigo200ParaRequisicaoDeCadastrarAbrigo() throws Exception {
        //ARRANGE
        String json = """
                {
                    "nome": "Abrigo feliz",
                    "telefone": "(94)0000-9090",
                    "email": "email@example.com.br"
                }
                """;

        //ACT
        MockHttpServletResponse response = mvc.perform(
                post("/abrigos")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        //ASSERT
        assertEquals(200,response.getStatus());
    }
    @Test
    void deveriaDevolver400CadastrarAbrigos() throws Exception {
        String json = """
                {
                    
                }
                """;
        MockHttpServletResponse response = mvc.perform(MockMvcRequestBuilders.post("/abrigos")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        Assertions.assertEquals(400,response.getStatus() );
    }

    @Test
    void deveriaDevolverCodigo200ParaRequisicaoDeListarPetsDoAbrigoPorNome() throws Exception {
        String nome = "Abrigo feliz";

        MockHttpServletResponse response = mvc.perform(MockMvcRequestBuilders.post("/abrigos/{nome}/pets", nome))
                .andReturn().getResponse();

        Assertions.assertEquals(200, response.getStatus());

    }

    @Test
    void deveriaDevolverCodigo200ParaRequisicaoDeListarPetsDoAbrigoPorId() throws Exception {
        String id = "1";

        MockHttpServletResponse response = mvc.perform(MockMvcRequestBuilders.get("/abrigos/{id}/pets",id))
                .andReturn().getResponse();

        Assertions.assertEquals(200, response.getStatus());
    }

    @Test
    void deveriaDevolverCodigo400ParaRequisicaoDeListarPetsDoAbrigoPorIdInvalido() throws Exception {
        String id = "1";
        BDDMockito.given(abrigoService.listarPetsDoAbrigo(id)).willThrow(ValidacaoException.class);

        MockHttpServletResponse response = mvc.perform(MockMvcRequestBuilders.post("/abrigos/{id}/pets",id))
                .andReturn()
                .getResponse();

        assertEquals(404,response.getStatus());

    }


}