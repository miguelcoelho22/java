package br.com.alura.filme;

import br.com.alura.calculadora.Avaliacao;

public class Series extends Titulo implements Avaliacao {
    private int temporadas;
    private int episodiosPorTemporadas;
    private boolean ativa;
    private int minutosPorEpisodios;

    public Series(String nome, int anoDeLancamento) {
        super(nome, anoDeLancamento);
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;

    }

    public int getMinutosPorEpisodios() {
        return minutosPorEpisodios;
    }

    public int getEpisodiosPorTemporadas() {
        return episodiosPorTemporadas;
    }

    public void setEpisodiosPorTemporadas(int episodiosPorTemporadas) {
        this.episodiosPorTemporadas = episodiosPorTemporadas;
    }

    public void setMinutosPorEpisodios(int minutosPorEpisodios) {
        this.minutosPorEpisodios = minutosPorEpisodios;
    }

    @Override
    public int getDuracaoEmMinutos() {
        return temporadas * episodiosPorTemporadas * minutosPorEpisodios;
    }


    @Override
    public int getavaliacao() {
        return (int) media() / 2;
    }

    @Override
    public String toString() {
        return "serie :  " + getNome();
    }
}
