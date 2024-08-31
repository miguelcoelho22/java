package com.example.projeto.herois.controller;

import com.example.projeto.herois.model.Player;
import com.example.projeto.herois.model.dto.PlayerDto;
import com.example.projeto.herois.service.PlayerService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;
    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody @Valid PlayerDto dto) {
        Player newPlayer = playerService.createPlayer(dto);
        return new ResponseEntity<>(newPlayer, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Player>> showPlayer() {
        List<Player> player = playerService.showPlayer();
        return new ResponseEntity<>(player, HttpStatus.OK);
    }
}
