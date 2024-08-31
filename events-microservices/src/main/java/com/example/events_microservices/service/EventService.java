package com.example.events_microservices.service;

import com.example.events_microservices.domain.Event;
import com.example.events_microservices.domain.Subscription;
import com.example.events_microservices.dtos.EmailRequest;
import com.example.events_microservices.dtos.EventRequestDTO;
import com.example.events_microservices.exceptions.EventFullException;
import com.example.events_microservices.exceptions.EventNotFoundException;
import com.example.events_microservices.repository.EventRepository;
import com.example.events_microservices.repository.SubscriptionRepository;
import com.sun.jdi.request.EventRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService {


    @Autowired
    private EventRepository repository;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private  EmailServiceClient emailServiceClient;

    public List<Event> getAllEvents () {
        return repository.findAll();
    }

    public List<Event> getUpcomingEvents () {
        return repository.findUpcomingEvents(LocalDateTime.now());
    }

    public Event createEvent (EventRequestDTO eventRequestDTO) {
        return repository.save(new Event(eventRequestDTO));
    }

    int registeredParticipantes = 0;
    public void registerParticipant(String eventId, String participantEmail) {
        Event event = repository.findById(eventId).orElseThrow(() -> new EventNotFoundException("evento nao encontrado"));

        if(registeredParticipantes > event.getMaxParticipants() ) {
            throw new EventFullException("evento cheio");
        }

        Subscription subscription = new Subscription(event, participantEmail);
        subscriptionRepository.save(subscription);

        EmailRequest emailRequest = new EmailRequest(participantEmail, "confirmaçao de inscriçao", "voce foi inscrito para o evento");

        emailServiceClient.sendEmail(emailRequest);
        registeredParticipantes += 1;

    }
}
