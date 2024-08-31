package br.com.alura.oficina.mecanima.barbeiro;

import br.com.alura.oficina.mecanima.endereco.DadosEndereco;
import br.com.alura.oficina.mecanima.endereco.Endereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroBarbeiro(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Pattern( regexp = "\\d{9,11}")
        String telefone,
        @NotNull
        Especialidade especialidade,
        @NotNull @Valid DadosEndereco endereco) {


}
