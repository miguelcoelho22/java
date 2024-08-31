package br.com.alura.oficina.mecanima.barbeiro;

import br.com.alura.oficina.mecanima.endereco.DadosEndereco;
import br.com.alura.oficina.mecanima.endereco.Endereco;

public record DadosAtualizacaoBarbeiro(
        Long id,
        String nome,
        String telefone,
        String email,
        DadosEndereco endereco
) {
}
