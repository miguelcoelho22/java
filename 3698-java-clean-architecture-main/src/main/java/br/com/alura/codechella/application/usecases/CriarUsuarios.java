package br.com.alura.codechella.application.usecases;


import br.com.alura.codechella.application.gateway.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

import java.util.List;

public class CriarUsuarios {

    private final RepositorioDeUsuario repository;

    public CriarUsuarios(RepositorioDeUsuario repository) {
        this.repository = repository;
    }


    public Usuario cadastrarUsuario(Usuario usuario) {
        return repository.cadastrarUsuario(usuario);
    }

    public List<Usuario> listarUsuario(){
        return repository.listarTodos();
    }
}
