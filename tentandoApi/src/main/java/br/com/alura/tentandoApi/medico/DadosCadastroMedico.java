package br.com.alura.tentandoApi.medico;

import br.com.alura.tentandoApi.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroMedico(
        @NotNull
        Long id,
            @NotBlank
                                  String nome,
                                  @NotBlank
                                  @Email
                                  String email,
                                  @NotBlank
                                  @Pattern( regexp = "\\d{9,11}")
                                  String telefone,
                                  @NotBlank
                                  @Pattern(regexp = "\\d{4,6}")
                                  String crm,
                                  @NotNull
                                  Especialidade especialidade,
                                  @NotNull @Valid DadosEndereco endereco
) {
}
