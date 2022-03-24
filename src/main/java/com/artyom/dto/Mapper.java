package com.artyom.dto;

import com.artyom.entities.Match;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public Match toMatch(MatchCreationDto matchDto){
        return new Match(matchDto.getDate(), matchDto.getHomeTeamGoals(),matchDto.getGuestTeamGoals());
    }
}
