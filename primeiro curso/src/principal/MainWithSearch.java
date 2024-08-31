package principal;


import br.com.alura.excetions.ErroDeConversaoException;
import br.com.alura.filme.Titulo;
import br.com.alura.filme.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




public class MainWithSearch {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        String movie = "";

        List<Titulo> lista = new ArrayList<>();

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();

        while (!movie.equalsIgnoreCase("sair")){

            System.out.println("qual o filme desejado");
            movie = scanner.nextLine();

            if(movie.equalsIgnoreCase("sair")){
                break;
        }

            String endereco = "https://www.omdbapi.com/?t=" + movie.replace(" ", "+") + "&apiKey=6d7af36";
            try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());



        TituloOmdb tituloOmdb = gson.fromJson(response.body(), TituloOmdb.class);
        System.out.println(tituloOmdb);
        Titulo titulo = new Titulo(tituloOmdb);
        System.out.println(titulo);

        lista.add(titulo);

        }   catch (NumberFormatException e){
                System.out.println("erro aconteceu um erro");
                System.out.println(e.getMessage());
            }
            catch (IllegalArgumentException e){
                System.out.println("erro");
            }
             catch(ErroDeConversaoException e){
                System.out.println(e.getMensagem());
            }
    }
        FileWriter fileWriter = new FileWriter("filmes.json");
        fileWriter.write(gson.toJson(lista));
        System.out.println(lista);
        fileWriter.close();
    }}

