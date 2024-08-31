package com.example.events_microservices.dtos;

public record EmailRequest(String to, String subject, String body) {
}
