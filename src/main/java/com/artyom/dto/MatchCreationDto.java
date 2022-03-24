package com.artyom.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MatchCreationDto {

    private Long seasonId;
    private LocalDate date;
    private Long homeTeamId;
    private Long guestTeamId;
    private int homeTeamGoals;
    private int guestTeamGoals;

    public MatchCreationDto() {
    }

}
