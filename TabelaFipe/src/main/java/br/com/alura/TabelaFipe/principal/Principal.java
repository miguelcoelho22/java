package br.com.alura.TabelaFipe.principal;

import br.com.alura.TabelaFipe.model.Dados;
import br.com.alura.TabelaFipe.model.Modelos;
import br.com.alura.TabelaFipe.model.Veiculo;
import br.com.alura.TabelaFipe.model.Veiculos;
import br.com.alura.TabelaFipe.service.ConsumoApi;
import br.com.alura.TabelaFipe.service.ConverteDados;
import br.com.alura.TabelaFipe.service.VeiculosRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {

    private Scanner scanner = new Scanner(System.in);
    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados converteDados = new ConverteDados();

    private VeiculosRepository repositorio;
    public Principal(VeiculosRepository repositorio) {
        this.repositorio = repositorio;
    }


    public void exibeMenu() {

        var menu = """
                 "opcoes"
                   carro
                   moto
                   caminhao
                   
                   digite uma das opcoes para consulta
            """;
        System.out.println(menu);

        var opcao = scanner.nextLine();
        String endereco;

        if(opcao.toLowerCase().contains("carr")){
            endereco = URL_BASE + "carros/marcas";
        }else if (opcao.toLowerCase().contains("mot")){
            endereco = URL_BASE + "motos/marcas";
        }else if (opcao.toLowerCase().contains("caminh")) {
            endereco = URL_BASE + "caminhoes/marcas";
        }else{
            System.out.println("nao identificamos o veiculo");
            endereco = null;
        }

        var json = consumoApi.obterDados(endereco);
        var marcas = converteDados.obterlista(json, Dados.class);

        marcas.stream().sorted(Comparator.comparing(Dados::codigo))
                        .forEach(System.out::println);


        System.out.println("informe a marca desejada");
        String codigomarca = scanner.nextLine();

        endereco = endereco + "/" + codigomarca + "/modelos";
        json = consumoApi.obterDados(endereco);
        var modeloLista = converteDados.obterDados(json,Modelos.class);

        modeloLista.modelos().stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        System.out.println("diite um trecho do veiculo desejado");
        var nomeVeiculo = scanner.nextLine();

        List<Dados> modelosFiltrados = modeloLista.modelos()
                .stream().filter(m -> m.nome().toLowerCase().contains(nomeVeiculo.toLowerCase()))
                .collect(Collectors.toList());

        modelosFiltrados.forEach(System.out::println);

        System.out.println("digite o codigo do modelo desejado");
        var modeloVeiculo = scanner.nextLine();

        endereco = endereco + "/" + modeloVeiculo + "/anos";
        json = consumoApi.obterDados(endereco);
        List<Dados> anos = converteDados.obterlista(json, Dados.class);
        //Veiculos veiculos = new Veiculos()
        //List<Veiculo> veiculos = new ArrayList<>();

        for (int i = 0; i < anos.size(); i++) {
            var enderecoAno = endereco + "/" + anos.get(i).codigo();
            json = consumoApi.obterDados(enderecoAno);
            Veiculo veiculo = converteDados.obterDados(json, Veiculo.class);
            Veiculos veiculos = new Veiculos(veiculo);
            repositorio.save(veiculos);
            //veiculos.add(veiculo);
        }
        System.out.println("veiculos filtrados por ano");
        List<Veiculos> veiculos = repositorio.findAll();
        veiculos.stream().sorted(Comparator.comparing(Veiculos::getAnoModelo))
                .forEach(System.out::println);
        //veiculos.forEach(System.out::println);




    }

}
