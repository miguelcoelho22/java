package alura.com.br.tabelafipedb.principal;

import alura.com.br.tabelafipedb.model.Cep;
import alura.com.br.tabelafipedb.model.PassarCep;
import alura.com.br.tabelafipedb.repository.CepRepository;
import alura.com.br.tabelafipedb.service.ConsumoApi;
import alura.com.br.tabelafipedb.service.ConverteDados;

import java.util.*;

public class Principal {
    private final String ENDERECO = "https://viacep.com.br/ws/";
    private final String API_KEY = "/json/";
    private Scanner scanner = new Scanner(System.in);
    private List<Cep> cepList = new ArrayList<>();
    private CepRepository repositorio;
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados converteDados = new ConverteDados();
    public Principal(CepRepository repositorio){
        this.repositorio = repositorio;
    }
    public void exibeMenu(){
        var opcao = -1;
        while(opcao!= 0){
            var menu = """
                    1 - cadastrar cep
                    2 - cep's cadastrados
                    3 - listar por estado
                    0 - sair 
                    """;
            System.out.println(menu);
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){
                case 1:
                    cadastrarCep();
                    break;
                case 2:
                    cepCadastrado();
                    break;
                case 3:
                    listarPorEstados();
                case 0:
                    System.out.println("saindo");
                    break;
            }

        }

    }

    private void listarPorEstados() {
        System.out.println("digite o estado");
        var estado = scanner.nextLine();
        List<Cep> filtrarEstado = repositorio.filtrarPorEstados(estado);
        filtrarEstado.forEach(System.out::println);

    }

    private void cepCadastrado() {
        System.out.println("todos os ceps cadastrados");
        cepList = repositorio.findAll();
        cepList.forEach(System.out::println);
    }

    private void cadastrarCep() {
        System.out.println("digite o cep");
        var cep = scanner.nextLine();
        var json = consumoApi.obterDados(ENDERECO + cep + API_KEY);
        PassarCep passarCep = converteDados.obterDados(json, PassarCep.class);
        Cep cep1 = new Cep(passarCep);
        repositorio.save(cep1);
        System.out.println(cep1);
    }
}
