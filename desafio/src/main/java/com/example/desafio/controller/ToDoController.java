package com.example.desafio.controller;

import com.example.desafio.domain.ToDo;
import com.example.desafio.dto.ToDoDtoEditar;
import com.example.desafio.dto.ToDoExcluir;
import com.example.desafio.service.ToDoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/todo")
public class ToDoController {

    @Autowired
    private ToDoService service;

    @PostMapping
    @Transactional
    public ResponseEntity<ToDo> criar(@RequestBody ToDoDto dto) {
        ToDo toDo = service.criar(dto);
        return new ResponseEntity<>(toDo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ToDo>> visualizar() {
        List<ToDo> toDoList = service.vizualizar();
        return new ResponseEntity<>(toDoList, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ToDo> editar(@RequestBody ToDoDtoEditar dto) throws Exception {
        ToDo toDo = service.editar(dto);
        return new ResponseEntity<>(toDo, HttpStatus.OK );
    }

    @DeleteMapping
    public ResponseEntity<ToDo> excluir(@RequestBody  ToDoExcluir dto) throws Exception {
        ToDo toDo = service.excluir(dto);
        return new ResponseEntity<>(toDo, HttpStatus.OK);
    }
}
