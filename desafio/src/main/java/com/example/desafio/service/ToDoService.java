package com.example.desafio.service;

import com.example.desafio.controller.ToDoController;
import com.example.desafio.controller.ToDoDto;
import com.example.desafio.domain.ToDo;
import com.example.desafio.dto.ToDoDtoEditar;
import com.example.desafio.dto.ToDoExcluir;
import com.example.desafio.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository repository;

    public ToDo criar(ToDoDto dto) {
        ToDo toDo = new ToDo(dto);
        repository.save(toDo);
        return toDo;
    }

    public List<ToDo> vizualizar() {
        return repository.findAll();
    }

    public ToDo editar(ToDoDtoEditar dto) throws Exception {
        if(repository.existsById(dto.id())){
        ToDo toDo = repository.getReferenceById(dto.id());
        toDo.editar(dto);
        return toDo;
    }
        throw new Exception("id nao encontrado no bando de dados");
    }

    public ToDo excluir(ToDoExcluir dto) throws Exception {
        if(repository.existsById(dto.id())) {
            ToDo todo = repository.getReferenceById(dto.id());
            repository.delete(todo);
            return todo;
        }

        throw new Exception("id nao encontrado");
    }
}
