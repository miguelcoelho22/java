package br.com.alura.oficina.mecanima.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Endereco {

    private String cidade;
    private String localizacaoBarbearia;


    public Endereco(DadosEndereco endereco) {
        this.cidade = endereco.cidade();
        this.localizacaoBarbearia = endereco.localizacaoBarbearia();
    }


    public void atualizarInformacoes(DadosEndereco endereco) {
        if(endereco.cidade() != null) {
            this.cidade = endereco.cidade();
        }
        if(endereco.localizacaoBarbearia() != null) {
            this.localizacaoBarbearia = endereco.localizacaoBarbearia();
        }
    }
}
