package com.example.gps.service;

import com.example.gps.GpsApplication;
import com.example.gps.domain.Gps;
import com.example.gps.domain.dto.GpsDto;
import com.example.gps.domain.dto.gpsDtoCoordenadas;
import com.example.gps.repository.GpsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

@Service
public class GpsService {

    @Autowired
    private GpsRepository repository;
    public Gps saveLocation(GpsDto dto) {
        return repository.save(new Gps(dto));
    }

    public List<Gps> findAll() {
        return repository.findAll();
    }

    public List<Gps> findLocation(gpsDtoCoordenadas dto) {
        var xMax = dto.coordenadaX() + dto.dMaxima();
        var xMin = dto.coordenadaX() - dto.dMaxima();

        var yMax = dto.coordenadaY() + dto.dMaxima();
        var yMin = dto.coordenadaY() - dto.dMaxima();

        return repository.acharCoordenadas(xMin, xMax, yMin, yMax);


    }
}
