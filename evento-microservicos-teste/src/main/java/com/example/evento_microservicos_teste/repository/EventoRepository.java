package com.example.evento_microservicos_teste.repository;

import com.example.evento_microservicos_teste.domain.Evento;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface EventoRepository extends JpaRepository<Evento, String> {

    @Query(value = "SELECT * FROM evento e WHERE PARSEDATETIME(e.data dd/MM/yyyy) > :dataLocal", nativeQuery = true)
    List<Evento> acharEventosDisponiveis(@Param("dataLocal") LocalDateTime data);

    @NonNull
    Optional<Evento> findById(@NonNull String id);
}
