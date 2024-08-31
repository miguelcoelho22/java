package com.example.events_microservices.dtos;

public record EventRequestDTO(int maxParticipants, String date, String title, String description) {
}
