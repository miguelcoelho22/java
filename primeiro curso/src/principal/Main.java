package principal;

import br.com.alura.calculadora.CalculadoraDeTempo;
import br.com.alura.calculadora.FiltroDeNota;
import br.com.alura.filme.Filme;
import br.com.alura.filme.Series;
import br.com.alura.filme.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Filme f1 = new Filme("mamonas assassinas" , 2022);
        f1.somaDasAvaliacoes(7);
        f1.somaDasAvaliacoes(10);
        System.out.println(f1.media());
        f1.informacoes();
        f1.setDuracaoEmMinutos(90);
        f1.setDuracaoEmMinutos(160);

        Filme f2 = new Filme("x-man", 2019);


        Series s1 = new Series("the last of us", 2022);
        s1.somaDasAvaliacoes(5);
        s1.somaDasAvaliacoes(8);
        System.out.println(s1.media());
        s1.setTemporadas(3);
        s1.setMinutosPorEpisodios(40);
        s1.setEpisodiosPorTemporadas(10);
        System.out.println(s1.getDuracaoEmMinutos());


        CalculadoraDeTempo calculadoraDeTempo = new CalculadoraDeTempo();
        calculadoraDeTempo.calculaOTempo(f1);
        calculadoraDeTempo.calculaOTempo(s1);
        System.out.println(calculadoraDeTempo.getResultado());

        FiltroDeNota filtro = new FiltroDeNota();
        filtro.filtra(f1);

        ArrayList<Titulo> item = new ArrayList<>();
        item.add(f1);
        item.add(f2);
        System.out.println(item.get(0).getNome());
        item.add(s1);




        for (int i = 0; i < item.size(); i++) {
            System.out.println(item);
            if (item.get(i) instanceof Filme) {
                Filme x = (Filme) item.get(i);
                System.out.println(x.getavaliacao());
            }

        }


        //Collections.sort(item);
        System.out.println(item);
        item.sort(Comparator.comparing(Titulo::getNome));
        System.out.println(item);

}
    }


