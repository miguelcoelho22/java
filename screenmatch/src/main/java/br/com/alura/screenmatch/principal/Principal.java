package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.bancodedados.ContaDAO;
import br.com.alura.screenmatch.bancodedados.DB;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;
import model.DadosEpisodio;
import model.DadosSeries;
import model.DadosTemporada;
import model.Episodio;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {

        DB connection;

        public Principal(){
            this.connection = new DB();
        }

        private final String ENDERECO = "https://www.omdbapi.com/?t=";
        private final String API_KEY = "&apiKey=6d7af36";

        private ConsumoApi consumoApi  = new ConsumoApi();
        private Scanner scanner = new Scanner(System.in);
        private ConverteDados converteDados = new ConverteDados();

        public void exibeMenu() {
            System.out.println("digite o nome da serie");
            String serie = scanner.nextLine();

            var json = consumoApi.obterDados(ENDERECO + serie.replace(' ', '+') + API_KEY);

            DadosSeries dadosSeries = converteDados.obterDados(json, DadosSeries.class);
            System.out.println(dadosSeries);

            Connection connection1 = connection.recuperarcoenxao();
            new ContaDAO(connection1).salvar(dadosSeries);

            List<DadosTemporada> temporadas = new ArrayList<>();



            for (int  i = 1; i <= dadosSeries.totalTemporadas(); i++){
                var json1 = consumoApi.obterDados(ENDERECO + serie.replace(' ', '+')+ "&season=" + i + API_KEY);
                DadosTemporada dadosTemporada = converteDados.obterDados(json1, DadosTemporada.class);
                temporadas.add(dadosTemporada);
            }
            temporadas.forEach(System.out::println);

            temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));

            List<DadosEpisodio> dadosEpisodios = temporadas.stream()
                    .flatMap(t -> t.episodios().stream())
                    .collect(Collectors.toList());

            dadosEpisodios.stream()
                    .filter(e -> !e.avaliacao().equalsIgnoreCase("N/A"))
                    .sorted(Comparator.comparing(DadosEpisodio::avaliacao).reversed())
                    .limit(5)
                    .forEach(System.out::println);


            List<Episodio> episodios = temporadas.stream()
                    .flatMap(t -> t.episodios().stream().map(e -> new Episodio(t.numero(), e)))
                    .collect(Collectors.toList());

            episodios.forEach(System.out::println);


            System.out.println("digite um trecho do episodio");

            var trechoTitulo = scanner.nextLine();
            Optional<Episodio> episodioBuscado = episodios.stream()
                    .filter(e -> e.getTitulo().toUpperCase().contains(trechoTitulo.toUpperCase()))
                    .findFirst();

            if(episodioBuscado.isPresent()){
                System.out.println("episodio encontrado");
                System.out.println("temporada" + episodioBuscado.get().getTemporada());
            }else{
                System.out.println("episodio nao encontrado");
            }
//
//            System.out.println("a partir de qual ano voce deseja ver os episodios");
//            var ano = scanner.nextInt();
//            scanner.nextLine();
//
//            LocalDate databusca = LocalDate.of(ano, 1, 1);
//
//            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//            episodios.stream()
//                    .filter(e -> e.getDataLancamento() != null &&  e.getDataLancamento().isAfter(databusca))
//            .forEach(e -> System.out.println("temporada: " + e.getTemporada() +
//                    "episodios" + e.getTitulo() +
//                    "data de lancamento" + e.getDataLancamento().format(formatador))
//
//
//            );

            Map<Integer, Double> avaliacaoPorTemporada = episodios.stream()
                    .filter(e -> e.getAvaliacao() > 0)
                    .collect(Collectors.groupingBy(Episodio::getTemporada,
                            Collectors.averagingDouble(Episodio::getAvaliacao)));
            System.out.println(avaliacaoPorTemporada);

            DoubleSummaryStatistics est = episodios.stream()
                    .filter(e -> e.getAvaliacao() > 0)
                    .collect(Collectors.summarizingDouble(Episodio::getAvaliacao));
            System.out.println("avaliacao max " + est.getMax());
            System.out.println("avaliacao minima " + est.getMin());
            System.out.println("media " + est.getAverage());
            System.out.println("quantidade avaliados " + est.getCount());
        }







}
