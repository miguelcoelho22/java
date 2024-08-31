package com.example.crud.domain.dto;

import com.example.crud.domain.Sexo;

public record UserDto(String name, Sexo sex, String phone, String age ) {
}
