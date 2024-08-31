package com.example.crud.controller;

import com.example.crud.domain.User;
import com.example.crud.domain.dto.UserDto;
import com.example.crud.domain.dto.UserDtoEditar;
import com.example.crud.domain.dto.UserDtoExcluir;
import com.example.crud.repository.CrudRepository;
import com.example.crud.service.CrudService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cadastro")
public class CrudController {

    @Autowired
    private CrudService service;

    @Autowired
    private CrudRepository repository;

    @PostMapping
    public ResponseEntity<User> cadastro(@RequestBody UserDto dto) {
        User user = service.cadastrar(dto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> listar() {
        List<User> user = service.listar();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/usuario")
    public ResponseEntity<Optional<User>> listarUsuario(@RequestBody UserDtoExcluir dtoExcluir) {
        Optional<User> user = service.listarUsuario(dtoExcluir);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<UserDtoEditar> editar(@RequestBody UserDtoEditar dtoEditar){
        User user = repository.getReferenceById(dtoEditar.id());
        user.editar(dtoEditar);

        return new ResponseEntity<>(dtoEditar, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<UserDtoExcluir> excluir(@RequestBody UserDtoExcluir dtoExcluir){
        service.excluir(dtoExcluir);
        return new ResponseEntity<>(dtoExcluir, HttpStatus.OK);
    }
}
