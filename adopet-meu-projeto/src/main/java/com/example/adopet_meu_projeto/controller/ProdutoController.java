package com.example.adopet_meu_projeto.controller;

import com.example.adopet_meu_projeto.dto.CadastroProdutoDto;
import com.example.adopet_meu_projeto.dto.ProdutoDTO;
import com.example.adopet_meu_projeto.service.ProdutoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    @Transactional
    public ResponseEntity<ProdutoDTO> produto (@Valid @RequestBody CadastroProdutoDto dto){
        ProdutoDTO produtoDto = produtoService.cadastrar(dto);

        return new ResponseEntity<>(produtoDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<ProdutoDTO>> listar(Pageable paginacao) {
        var page = produtoService.listar(paginacao);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        produtoService.excluir(id);

    }
}
