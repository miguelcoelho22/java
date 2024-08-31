package _daysofcode.br.com.alura.Service;

import _daysofcode.br.com.alura.repository.SerieRepository;
import _daysofcode.br.com.alura.requestresponse.ConsumoApi;
import _daysofcode.br.com.alura.requestresponse.ConverteDados;
import _daysofcode.br.com.alura.serie.NomeSerie;
import _daysofcode.br.com.alura.serie.Serie;
import _daysofcode.br.com.alura.serie.SerieDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SerieService {

    private ConsumoApi consumoApi;


    private ConverteDados converteDados;

//    @Autowired
//    private SerieRepository serieRepository;
//    public void SalvarSerie(String nome){
//        var endereco = consumoApi.obterDados(nome);
//        SerieDto dto = converteDados.converteDados(endereco, SerieDto.class);
//
//        serieRepository.save(new Serie(dto));
//    }
}
