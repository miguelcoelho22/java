package com.example.projeto.herois.infra;

import com.example.projeto.herois.model.GroupType;
import com.example.projeto.herois.service.CodinameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class CodinameHandler {

    @Autowired
    private CodinameService service;

    public String findCodiname(GroupType groupType) {
        if(groupType == GroupType.AVENGERS) {
            String heroi = service.getAvangersCodinameList().stream().findFirst().orElseThrow();
            this.service.getAvangersCodinameList().remove(heroi);
            return heroi;
        }
        String heroi = service.getJusticeLeagueList().stream().findFirst().orElseThrow();
        this.service.getJusticeLeagueList().remove(heroi);
        return heroi;
    }
}
