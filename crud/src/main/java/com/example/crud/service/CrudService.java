package com.example.crud.service;

import com.example.crud.domain.User;
import com.example.crud.domain.dto.UserDto;
import com.example.crud.domain.dto.UserDtoEditar;
import com.example.crud.domain.dto.UserDtoExcluir;
import com.example.crud.repository.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CrudService {
    @Autowired
    private CrudRepository repository;
    public User cadastrar(UserDto dto) {
        return repository.save(new User(dto));
    }

    public List<User> listar() {
        return repository.findAll();
    }

    public void editar(UserDtoEditar dtoEditar) {

        User user = repository.getReferenceById(dtoEditar.id());
        user.editar(dtoEditar);
    }

    public void excluir(UserDtoExcluir dtoExcluir) {
        User user = repository.getReferenceById(dtoExcluir.id());
        repository.delete(user);

    }

    public Optional<User> listarUsuario(UserDtoExcluir dtoExcluir) {
        return repository.findById(dtoExcluir.id());
    }
}
