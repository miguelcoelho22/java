package br.com.alura.filme;

import br.com.alura.excetions.ErroDeConversaoException;

public class Titulo implements Comparable<Titulo> {

    private String nome;

    private int anoDeLancamento;
    int duracaoEmMinutos;
    private double avaliaçao;
    private int quantidadeDeAvaliaçoes;

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOmdb tituloOmdb) {
        this.nome = tituloOmdb.title();

        if (tituloOmdb.year().length() > 4 ){
            throw new ErroDeConversaoException("nao consegui converter");
        }
        this.anoDeLancamento = Integer.valueOf(tituloOmdb.year());
        this.duracaoEmMinutos = Integer.valueOf(tituloOmdb.runtime().substring(0, 2));
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void informacoes() {
        System.out.println(nome);
    }
    public void somaDasAvaliacoes(double nota) {
        avaliaçao += nota;
        quantidadeDeAvaliaçoes++;
    }

    public double media() {
        return avaliaçao / quantidadeDeAvaliaçoes;
    }


    @Override
    public int compareTo(Titulo o) {
        return this.getNome().compareTo(o.getNome());
    }


    @Override
    public String toString() {
        return "nome='" + nome + '\'' +
                ", anoDeLancamento=" + anoDeLancamento +
                '}' + "duraçao" + duracaoEmMinutos;
    }
}