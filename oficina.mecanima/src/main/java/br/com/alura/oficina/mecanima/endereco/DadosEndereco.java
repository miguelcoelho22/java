package br.com.alura.oficina.mecanima.endereco;

import br.com.alura.oficina.mecanima.barbeiro.Barbeiro;
import br.com.alura.oficina.mecanima.barbeiro.DadosCadastroBarbeiro;
import jakarta.validation.constraints.NotBlank;

public record  DadosEndereco(
        @NotBlank
        String cidade,
        @NotBlank
        String localizacaoBarbearia) {

        public  DadosEndereco(Endereco d) {
                this(d.getCidade(), d.getLocalizacaoBarbearia());
        }

}
