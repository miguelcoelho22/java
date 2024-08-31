package _daysofcode.br.com.alura.controller;

import _daysofcode.br.com.alura.repository.SerieRepository;
import _daysofcode.br.com.alura.requestresponse.ConsumoApi;
import _daysofcode.br.com.alura.requestresponse.ConverteDados;
import _daysofcode.br.com.alura.serie.Serie;
import _daysofcode.br.com.alura.serie.SerieDto;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/series")
public class Controller {
    private ConsumoApi consumoApi;

    private ConverteDados converteDados;

    private SerieRepository serieRepository;
    @PostMapping("{nomeSerie}")
    @Transactional
    public ResponseEntity listar(@PathVariable String nomeSerie) {

        var json = consumoApi.obterDados(nomeSerie);
        SerieDto serieDto = converteDados.converteDados(json, SerieDto.class);
//        serieRepository.save(new Serie(json));
        return ResponseEntity.ok(serieDto);

    }

}
