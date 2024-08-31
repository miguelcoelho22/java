package br.com.alura.filme;

import br.com.alura.calculadora.Avaliacao;

public class Episodio implements Avaliacao {
    private String nome;
    private int numero;
    private Series serie;

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Series getSerie() {
        return serie;
    }

    public void setSerie(Series serie) {
        this.serie = serie;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public int getavaliacao() {
        return 0;
    }
}
