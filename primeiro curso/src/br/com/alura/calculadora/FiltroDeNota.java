package br.com.alura.calculadora;

public class FiltroDeNota {
    public void filtra(Avaliacao sf) {
        if(sf.getavaliacao() >= 4) {
            System.out.println("top");
        }else if(sf.getavaliacao() >= 2) {
            System.out.println("mais ou menos");
        }else {
            System.out.println("lixo");
        }
    }
}
