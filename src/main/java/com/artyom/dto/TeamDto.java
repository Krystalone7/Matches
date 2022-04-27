package com.artyom.dto;

import lombok.Getter;

@Getter
public class TeamDto {

    private final Long teamId;
    private final String teamName;

    public TeamDto(Long teamId, String teamName) {
        this.teamId = teamId;
        this.teamName = teamName;
    }
}
