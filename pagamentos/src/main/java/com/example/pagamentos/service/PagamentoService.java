package com.example.pagamentos.service;

import com.example.pagamentos.domain.Pagamento;
import com.example.pagamentos.domain.Status;
import com.example.pagamentos.dto.PagamentoDto;
import com.example.pagamentos.repository.PagamentoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository repository;

    @Autowired
    private ModelMapper mapper;

    public Page<PagamentoDto> obterTodos(Pageable paginacao) {
        return repository.findAll(paginacao).map(pagamento -> mapper.map(pagamento, PagamentoDto.class));
    }

    public PagamentoDto obterPorId( Long id) {
        Pagamento pagamento = repository.findById(id).orElseThrow(EntityNotFoundException::new);

        return mapper.map(pagamento, PagamentoDto.class);
    }

    public PagamentoDto criarPagamento(PagamentoDto dto) {
        Pagamento pagamento = mapper.map(dto, Pagamento.class);
        pagamento.setStatus(Status.CRIADO);
        repository.save(pagamento);

        return mapper.map(pagamento, PagamentoDto.class);
    }

    public PagamentoDto atualizarPagamento(Long id, PagamentoDto dto){
        Pagamento pagamento = mapper.map(dto, Pagamento.class);
        pagamento.setId(id);
        repository.save(pagamento);
        return mapper.map(pagamento, PagamentoDto.class);

    }

    public void  deletar(Long id){
        repository.deleteById(id);
    }
}
