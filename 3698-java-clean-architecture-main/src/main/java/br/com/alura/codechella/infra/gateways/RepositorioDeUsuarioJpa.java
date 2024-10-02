package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.application.gateway.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.persistence.UsuarioEntity;
import br.com.alura.codechella.infra.persistence.UsuarioRepositoryJpa;

import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeUsuarioJpa implements RepositorioDeUsuario {

    private final UsuarioRepositoryJpa repositoryJpa;

    private final UsuarioEntityMapper mapper;

    public RepositorioDeUsuarioJpa(UsuarioRepositoryJpa repositoryJpa, UsuarioEntityMapper mapper) {
        this.repositoryJpa = repositoryJpa;
        this.mapper = mapper;
    }

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        UsuarioEntity entity = repositoryJpa.save(mapper.newUsuarioEntity(usuario));
        return mapper.newUsuario(entity);
    }

    @Override
    public List<Usuario> listarTodos() {
        return repositoryJpa.findAll().stream().map(mapper::newUsuario).collect(Collectors.toList());
    }
}
