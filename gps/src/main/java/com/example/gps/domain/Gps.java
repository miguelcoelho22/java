package com.example.gps.domain;

import com.example.gps.domain.dto.GpsDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "gps")
@Table(name = "gps")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Gps {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private Long coordinateX;
    private Long coordinateY;


    public Gps(GpsDto dto) {
        this.name = dto.nome();
        this.coordinateX = dto.coordenadaX();
        this.coordinateY = dto.coordenadaY();
    }
}
