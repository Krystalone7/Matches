package com.artyom.dto;

import com.artyom.entities.Team;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Position {

    private TeamDto teamDto;
    private int score = 0;
    private int gamesCount = 0;

    public Position(TeamDto teamDto) {
        this.teamDto = teamDto;
    }

    public void updateScore(int points){
        score += points;
    }

    public void incGamesCount(){
        gamesCount++;
    }
}
