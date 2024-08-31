package com.example.pagamentos.controller;

import com.example.pagamentos.dto.PagamentoDto;
import com.example.pagamentos.service.PagamentoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService service;

    @GetMapping
    public ResponseEntity<Page<PagamentoDto>> obterTodos (@PageableDefault(size = 10) Pageable paginacao) {
        Page<PagamentoDto> dto = service.obterTodos(paginacao);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoDto> obterPorId (@PathVariable Long id) {
        PagamentoDto dto = service.obterPorId(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PagamentoDto> criarPagamento (@RequestBody @Valid PagamentoDto dto) {
        PagamentoDto pagamentoDto = service.criarPagamento(dto);
        return new ResponseEntity<>(pagamentoDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PagamentoDto> atualizarPagamento (@PathVariable @NotNull Long id, @RequestBody @Valid PagamentoDto dto) {
        PagamentoDto pagamentoDto = service.atualizarPagamento(id, dto);
        return new ResponseEntity<>(pagamentoDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable @NotNull Long id) {
        service.deletar(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
