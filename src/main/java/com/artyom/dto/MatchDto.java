package com.artyom.dto;

import lombok.Getter;

@Getter
public class MatchDto {

    private final String id;
    private final String date;
    private final SeasonDto seasonDto;
    private final String homeTeamName;
    private final String guestTeamName;
    private final int homeTeamGoals;
    private final int guestTeamGoals;

    public MatchDto(String id, String date, SeasonDto seasonDto, String homeTeamName, String guestTeamName, int homeTeamGoals, int guestTeamGoals) {
        this.id = id;
        this.date = date;
        this.seasonDto = seasonDto;
        this.homeTeamName = homeTeamName;
        this.guestTeamName = guestTeamName;
        this.homeTeamGoals = homeTeamGoals;
        this.guestTeamGoals = guestTeamGoals;
    }
}
