import br.com.alura.cep.ConsultaCep;
import br.com.alura.cep.Endereco;
import br.com.alura.cep.GeradorDeArquivo;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("digite um cep");
        String resposta = scanner.next();

        ConsultaCep consultaCep = new ConsultaCep();

    try {
        Endereco novoendereco = consultaCep.endereco(resposta);
        System.out.println(novoendereco);
        GeradorDeArquivo geradorDeArquivo = new GeradorDeArquivo();
        geradorDeArquivo.salvaJson(novoendereco);
    }catch (RuntimeException | IOException e){
        System.out.println(e.getMessage());
    }
    }

}