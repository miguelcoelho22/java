package br.com.alura.codechella.domain.entities.usuarios;

import br.com.alura.codechella.domain.entities.usuario.FabricaDeUsuarios;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UsuarioTeste {

    @Test
    void naoDeveCadastrarUsuarioComCpfNoFormatoInvalido() {
        //arrange

        //act

        //assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Usuario("123313131-12", "miguel", LocalDate.parse("1990-02-02"), "miguel@gmail.com"));
    }

    @Test
    void DeveCadastrarUsuarioComCpfNoFormatovalido() {
        Assertions.assertDoesNotThrow(() -> new Usuario("133.517.526-10", "miguel", LocalDate.parse("1990-02-02"), "miguel@gmail.com"));
    }

    @Test
    void deveCriarUsuarioComAFabrica() {
        FabricaDeUsuarios fabricaDeUsuarios = new FabricaDeUsuarios();
        Usuario usuario = fabricaDeUsuarios.comCpfEmailNome("miguel", "623.123.897-88", LocalDate.parse("1990-02-02"));

        Assertions.assertEquals("miguel", usuario.getNome());

        usuario = fabricaDeUsuarios.incluirEndereco("35500-000", 11, "casa");
        Assertions.assertEquals(11, usuario.getEndereco().getNumero());
    }

}
