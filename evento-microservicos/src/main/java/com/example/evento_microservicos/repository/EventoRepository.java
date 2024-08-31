package com.example.evento_microservicos.repository;

import com.example.evento_microservicos.domain.Evento;
import feign.Param;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface EventoRepository extends JpaRepository<Evento, String> {

    @Query(value = "SELECT * FROM evento e WHERE PARSEDATETIME(e.date dd/MM/yyyy) > :dataLocal)", nativeQuery = true)
    List<Evento> acharEventosDisponiveis (@Param("dataLocal") LocalDateTime dataLocal);

    @NonNull
    Optional<Evento> findById(@NonNull  String id);
}
