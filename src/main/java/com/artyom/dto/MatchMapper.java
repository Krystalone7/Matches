package com.artyom.dto;

import com.artyom.entities.Match;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class MatchMapper {

    public Match toMatch(MatchCreationDto matchDto){
        return new Match(LocalDate.parse(matchDto.getDate()), matchDto.getHomeTeamGoals(),matchDto.getGuestTeamGoals());
    }
}
