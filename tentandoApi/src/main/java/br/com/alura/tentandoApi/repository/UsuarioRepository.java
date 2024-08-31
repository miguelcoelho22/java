package br.com.alura.tentandoApi.repository;

import br.com.alura.tentandoApi.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


    UserDetails findByLogin(String username);

}
