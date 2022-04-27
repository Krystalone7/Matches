package com.artyom.dto;

import com.artyom.entities.Team;
import org.springframework.stereotype.Component;

@Component
public class TeamMapper {

    public TeamDto teamToDto (Team team){
        return new TeamDto(team.getId(), team.getTeamName());
    }
}
