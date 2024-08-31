package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.model.*;
import br.com.alura.screenmatch.repository.SerieRepository;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.stream.Collectors;

public class Principal {


    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=6585022c";
    private List<DadosSerie> dadosSeries = new ArrayList<>();
    private List<Serie> series = new ArrayList<>();
    private SerieRepository repositorio;
    private Optional<Serie> serieBusca;
    private Serie buscaserie = new Serie();
    private int quantidadeTemporadas;
    private List<Serie> quantidadeTemporadaList;

    public Principal(SerieRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void exibeMenu() {
        var opcao = -1;
        while (opcao != 0){
        var menu = """
                1 - Buscar séries
                2 - Buscar episódios
                3 - listar series buscadas
                4 - buscar por titulo
                5- buscar por ator
                6- top 5 series
                7- procurar por categoria
                8- ordenar por temporadas
                9- episodio
                10- top 5 episodios por serie
                11- buscar episodios a partir de uma data
                0 - Sair                                 
                """;

        System.out.println(menu);
        opcao = leitura.nextInt();
        leitura.nextLine();

        switch (opcao) {
            case 1:
                buscarSerieWeb();
                break;
            case 2:
                buscarEpisodioPorSerie();
                break;
            case 3:
                listarSeriesBuscadas();
                break;
            case 4:
                procurarPorTitulo();
                break;
            case 5:
                buscarSeriePorAtor();
            case 6:
                bucasrTop5Series();
                break;
            case 7:
                buscarPorCategoria();
                break;
            case 8:
                ordenarPorTemporada();
                break;
            case 9:
                buscarEpisodioPorTrecho();
                break;
            case 10:
                top5Episodios();
                break;
            case 11:
                buscarEpisodiosDepoisDeUmaData();
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida");
            }
        }
    }

    private void buscarEpisodiosDepoisDeUmaData() {
        procurarPorTitulo();
        if(serieBusca.isPresent()){
            Serie serie = serieBusca.get();
            System.out.println("qual a data desejada");
            var anoLancamento = leitura.nextInt();
            leitura.nextLine();

            List<Episodio> episodiosAno = repositorio.episodiosPorSerieEAno(serie, anoLancamento);
            episodiosAno.forEach(System.out::println);

        }
    }


    private void buscarEpisodioPorTrecho() {
        System.out.println("digite o nome  do episodio");
        var nomeEpisodio = leitura.nextLine();
        List<Episodio> episodiosEncontrados = repositorio.episodiosPorTrecho(nomeEpisodio);
        episodiosEncontrados.forEach(e -> System.out.println(
                 e.getSerie().getTitulo() +
                 e.getTemporada() +
                 e.getNumeroEpisodio() + e.getTitulo()
        ));

    }

    private void ordenarPorTemporada() {
        System.out.println("quantidades de temporadas pretentida");
        var quantidadeTemporadas = leitura.nextInt();
        leitura.nextLine();
        System.out.println("com avaliacao a partir de qual valor?");
        var avaliacao = leitura.nextDouble();
        leitura.nextLine();
        List<Serie> quantidadeTemporadaList = repositorio.seriesPorTemporadaEAvaliacao(quantidadeTemporadas, avaliacao);
        quantidadeTemporadaList.forEach(System.out::println);

    }

    private void buscarPorCategoria() {
        System.out.println("digite a categoria pretendida");
        var resposta = leitura.nextLine();
        Categoria categoria = Categoria.fromPortugues(resposta);
        List<Serie> seriesPorCategoria = repositorio.findByGenero(categoria);
        seriesPorCategoria.forEach(System.out::println);
    }

    private void bucasrTop5Series() {
        List<Serie> topSeries = repositorio.findTop5ByOrderByAvaliacaoDesc();
        topSeries.forEach(System.out::println);
    }



    private void buscarSeriePorAtor() {
        System.out.println("digite o nome do ator");
        var ator = leitura.nextLine();
        System.out.println("avaliacao a partir de qual valor");
        var avaliacao = leitura.nextDouble();
        List<Serie> seriesDoAtor = repositorio.findByAtoresContainingIgnoreCaseAndAvaliacaoGreaterThanEqual(ator, avaliacao);
        seriesDoAtor.forEach(s -> System.out.println(s.getTitulo() + s.getAvaliacao()));
    }

    private void procurarPorTitulo() {
        System.out.println("digite o titulo desejado");
        var titulo = leitura.nextLine();
        serieBusca = repositorio.findByTituloContainingIgnoreCase(titulo);
        if(serieBusca.isPresent()){
            System.out.println(serieBusca.get());
        }else {
            System.out.println("nome nao encontrado");
        }
    }

    private void buscarSerieWeb() {
        DadosSerie dados = getDadosSerie();
        Serie serie = new Serie(dados);
        repositorio.save(serie);
        //dadosSeries.add(dados);
        System.out.println(dados);

    }

    private DadosSerie getDadosSerie() {
        System.out.println("Digite o nome da série para busca");
        var nomeSerie = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        return dados;
    }

    private void buscarEpisodioPorSerie(){
        listarSeriesBuscadas();
        System.out.println("digite a serie que voce quer");
        var serie = leitura.nextLine();
        Optional<Serie> serieOptional = series.stream().filter(s -> s.getTitulo().toLowerCase().contains(serie.toLowerCase()))
                .findFirst();
        if(serieOptional.isPresent()){
            var serieEncontrada = serieOptional.get();
        List<DadosTemporada> temporadas = new ArrayList<>();

        for (int i = 1; i <= serieEncontrada.getTotalTemporadas(); i++) {
            var json = consumo.obterDados(ENDERECO + serieEncontrada.getTitulo().replace(" ", "+") + "&season=" + i + API_KEY);
            DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
            temporadas.add(dadosTemporada);
        }
        temporadas.forEach(System.out::println);

            List<Episodio> episodioList = temporadas.stream()
                    .flatMap(d -> d.episodios().stream()
                            .map(e -> new Episodio(d.numero(), e)))
                    .collect(Collectors.toList());
            serieEncontrada.setEpisodios(episodioList);
            repositorio.save(serieEncontrada);
        }else{
            System.out.println("serie nao encontrada");
        }
    }
    private void listarSeriesBuscadas(){

        series = repositorio.findAll();
        series.stream().sorted(Comparator.comparing(Serie::getGenero))
                .forEach(System.out::println);
    }

    private void top5Episodios() {
        procurarPorTitulo();
        if(serieBusca.isPresent()){
            Serie serie = serieBusca.get();
            List<Episodio> topEpisodios = repositorio.topEpisodiosPorSerie(serie);
            topEpisodios.forEach(e ->
                    System.out.printf("Série: %s Temporada %s - Episódio %s - %s Avaliação %s\n",
                            e.getSerie().getTitulo() , e.getTemporada(),
                            e.getNumeroEpisodio(), e.getTitulo(), e.getAvaliacao()));
        }

    }
}