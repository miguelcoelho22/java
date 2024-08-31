package com.example.events_microservices.exceptions;

public class EventFullException extends RuntimeException{

    public EventFullException (String message) {
        super (message);
    }
}
