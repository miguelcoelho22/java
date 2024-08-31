package alura.com.br.tabelafipedb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PassarCep(String cep, String bairro, String localidade, String uf, String ddd) {
}
