package com.example.gps.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record gpsDtoCoordenadas(@NotNull  Long coordenadaX, @NotNull  Long coordenadaY,@NotNull Long dMaxima) {
}
