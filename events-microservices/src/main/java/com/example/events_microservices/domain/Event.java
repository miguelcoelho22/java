package com.example.events_microservices.domain;

import com.example.events_microservices.dtos.EventRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "event")
@Entity(name = "event")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private int maxParticipants;
    private String date;
    private String title;
    private String description;

    public Event(EventRequestDTO eventRequestDTO) {
        this.maxParticipants = eventRequestDTO.maxParticipants();
        this.date = eventRequestDTO.date();
        this.title = eventRequestDTO.title();
        this.description = eventRequestDTO.description();
    }
}
