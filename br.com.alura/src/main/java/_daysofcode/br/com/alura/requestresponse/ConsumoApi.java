package _daysofcode.br.com.alura.requestresponse;

import _daysofcode.br.com.alura.serie.SerieDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {
    private SerieDto serieDto;

    HttpResponse<String> resposta;
    public String obterDados(String endereco) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://www.omdbapi.com/?t=" + endereco + "&apiKey=6d7af36"))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            resposta = response;
//            ObjectMapper mapper = new ObjectMapper();
//            serieDto = mapper.readValue(response.body(), SerieDto.class );
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        return resposta.body();

    }
}
