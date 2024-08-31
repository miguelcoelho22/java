package com.example.gps.repository;

import com.example.gps.domain.Gps;
import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface GpsRepository extends JpaRepository<Gps, Long> {

    @Query("SELECT g FROM gps g WHERE g.coordinateX >= :distanciaXMin and g.coordinateX <= :distanciaXMax and g.coordinateY >= :distanciaYMin and g.coordinateY <= :distanciaYMax")
    List<Gps> acharCoordenadas(Long distanciaXMin, Long distanciaXMax, Long distanciaYMin, Long distanciaYMax);

}
