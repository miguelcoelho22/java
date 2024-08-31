package br.com.alura.filme;

import br.com.alura.calculadora.Avaliacao;

public class Filme extends Titulo implements Avaliacao {
   private String diretor;

    public Filme(String nome, int anoDeLancamento) {
        super(nome , anoDeLancamento);
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public int getavaliacao() {
        return (int) media() / 2;
    }

    @Override
    public String toString() {
        return "filme : " + getNome() + "( " + getAnoDeLancamento() + " )";
    }
}
