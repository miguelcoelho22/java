package com.example.projeto.herois.service;

import com.example.projeto.herois.Repository.PlayerRepository;
import com.example.projeto.herois.infra.CodinameHandler;
import com.example.projeto.herois.model.GroupType;
import com.example.projeto.herois.model.Player;
import com.example.projeto.herois.model.dto.PlayerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private CodinameHandler codinameHandler;

    public Player createPlayer(PlayerDto dto) {
       Player player =  new Player(dto);
       String codiname = getCodiname(dto.groupType());
       player.setCodiname(codiname);
       return playerRepository.save(player);

    }

    public List<Player> showPlayer() {
        return playerRepository.findAll();
    }

    private String getCodiname(GroupType groupType) {
        return codinameHandler.findCodiname(groupType);
    }
}
