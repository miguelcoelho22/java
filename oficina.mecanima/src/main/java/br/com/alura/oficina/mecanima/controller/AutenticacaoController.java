package br.com.alura.oficina.mecanima.controller;

import br.com.alura.oficina.mecanima.infra.security.TokenDTO;
//import br.com.alura.oficina.mecanima.infra.security.TokenService;
import br.com.alura.oficina.mecanima.usuario.DadosAutenticacao;
import br.com.alura.oficina.mecanima.usuario.Usuario;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

//    @Autowired
//    private TokenService service;

    @PostMapping
    public ResponseEntity salvar(@RequestBody @Valid DadosAutenticacao dados) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(authenticationToken);

//        var tokenJWT = service.gerarToken((Usuario) authentication.getPrincipal());

//        return ResponseEntity.ok(new TokenDTO(tokenJWT));

        return ResponseEntity.ok("");
    }
}
