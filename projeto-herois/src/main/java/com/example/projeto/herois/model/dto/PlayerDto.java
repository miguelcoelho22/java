package com.example.projeto.herois.model.dto;

import com.example.projeto.herois.model.GroupType;

public record PlayerDto(String name, String email, String phoneNumber, GroupType groupType) {
}
