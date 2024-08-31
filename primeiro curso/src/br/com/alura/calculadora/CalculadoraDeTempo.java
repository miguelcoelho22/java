package br.com.alura.calculadora;

import br.com.alura.filme.Titulo;

public class CalculadoraDeTempo {
    private int resultado;

    public int getResultado() {
        return resultado;
    }

    public void calculaOTempo(Titulo t) {
        resultado += t.getDuracaoEmMinutos();
    }
}
