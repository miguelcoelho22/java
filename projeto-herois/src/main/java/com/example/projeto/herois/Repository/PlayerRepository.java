package com.example.projeto.herois.Repository;

import com.example.projeto.herois.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
