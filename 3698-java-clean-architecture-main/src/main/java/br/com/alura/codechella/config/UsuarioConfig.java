package br.com.alura.codechella.config;

import br.com.alura.codechella.application.gateway.RepositorioDeUsuario;
import br.com.alura.codechella.application.usecases.CriarUsuarios;
import br.com.alura.codechella.infra.gateways.RepositorioDeUsuarioJpa;
import br.com.alura.codechella.infra.gateways.UsuarioEntityMapper;
import br.com.alura.codechella.infra.persistence.UsuarioRepositoryJpa;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {

    @Bean
    CriarUsuarios criarUsuarios (RepositorioDeUsuario repositorioDeUsuario) {
        return new CriarUsuarios(repositorioDeUsuario);
    }

    @Bean
    RepositorioDeUsuarioJpa repositorioDeUsuarioJpa(UsuarioRepositoryJpa jpa, UsuarioEntityMapper mapper){
        return new RepositorioDeUsuarioJpa(jpa, mapper);
    }


    @Bean
    UsuarioEntityMapper usuarioEntityMapper(){
    return new UsuarioEntityMapper();
    }
}