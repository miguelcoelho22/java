package com.example.events_microservices.controller;

import com.example.events_microservices.domain.Event;
import com.example.events_microservices.dtos.EventRequestDTO;
import com.example.events_microservices.dtos.SubscriptionDTO;
import com.example.events_microservices.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService service;

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents () {
        List<Event> eventList =  service.getAllEvents();
        return new ResponseEntity<>(eventList, HttpStatus.OK);
    }

    @GetMapping("/upcoming")
    public ResponseEntity<List<Event>> getUpcomingEvents () {
        List<Event> eventList = service.getUpcomingEvents();
        return new ResponseEntity<>(eventList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Event> createEvent (@RequestBody EventRequestDTO dto) {
        Event event = service.createEvent(dto);
        return new ResponseEntity<>(event, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/register")
    public ResponseEntity registerParticipant(@PathVariable String id, @RequestBody SubscriptionDTO dto) {
        service.registerParticipant(id, dto.participantEmail());
        return new ResponseEntity (HttpStatus.CREATED);
    }
}
