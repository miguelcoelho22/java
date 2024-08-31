package br.com.alura.cep;

public record Endereco(String cep, String logradouro, String complemento, String localidade, String uf, String ddd) {
}
