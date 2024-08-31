package com.example.crud.domain.dto;

import com.example.crud.domain.Sexo;

public record UserDtoEditar(Long id, String phone, String age, String name, Sexo sex) {
}
