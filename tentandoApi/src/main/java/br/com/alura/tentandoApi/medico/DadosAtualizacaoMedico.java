package br.com.alura.tentandoApi.medico;

import br.com.alura.tentandoApi.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedico(@NotNull
                                     Long id,
                                     String nome,
                                     String telefone,
                                     DadosEndereco endereco) {
}
