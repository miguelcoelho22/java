package com.example.gps.controller;

import com.example.gps.domain.Gps;
import com.example.gps.domain.dto.GpsDto;
import com.example.gps.domain.dto.gpsDtoCoordenadas;
import com.example.gps.service.GpsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/localizacao")
public class GpsController {

    @Autowired
    private GpsService gpsService;

    @PostMapping
    public ResponseEntity<Gps> saveLocation (@RequestBody  GpsDto dto) {
        Gps gps = gpsService.saveLocation(dto);
        return new ResponseEntity<>(gps, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<Gps>> showLocations () {
        List<Gps> gps = gpsService.findAll();
        return new ResponseEntity<>(gps, HttpStatus.OK);
    }

    @GetMapping("/localizacao")
    public  ResponseEntity<List<Gps>> Bycoordinaties (@RequestBody  @Valid gpsDtoCoordenadas dto) {
        List<Gps> gpsList = gpsService.findLocation(dto);
        return new ResponseEntity<>(gpsList, HttpStatus.OK);
    }

}
