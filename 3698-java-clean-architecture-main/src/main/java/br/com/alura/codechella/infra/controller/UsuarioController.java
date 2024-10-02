package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.application.usecases.CriarUsuarios;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final CriarUsuarios criarUsuarios;

    public UsuarioController(CriarUsuarios criarUsuarios) {
        this.criarUsuarios = criarUsuarios;
    }

    @PostMapping
    public UsuarioDto newUser (UsuarioDto dto) {
        criarUsuarios.cadastrarUsuario(new Usuario(dto.cpf(), dto.nome(),dto.nascimento(),dto.email()));

        return dto;
    }

    @GetMapping
    public List<UsuarioDto> listarUsuario() {
        return criarUsuarios.listarUsuario().stream().map(usuario -> new UsuarioDto
                (usuario.getCpf(), usuario.getNome(), usuario.getNascimento(),usuario.getEmail())).collect(Collectors.toList());
    }
}
