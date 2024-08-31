package com.example.picpay.domain;

import java.math.BigDecimal;

public record UserDto(String firstName, String lastName, String cpf, String email, String password, UserType userType, BigDecimal balance) {
}
