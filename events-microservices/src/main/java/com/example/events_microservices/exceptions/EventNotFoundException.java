package com.example.events_microservices.exceptions;

public class EventNotFoundException extends RuntimeException{
    public EventNotFoundException (String message) {
        super(message);
    }


}
