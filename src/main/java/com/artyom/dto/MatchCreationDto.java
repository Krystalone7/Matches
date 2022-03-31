package com.artyom.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MatchCreationDto {

    private String seasonId;
    private String date;
    private String homeTeamId;
    private String guestTeamId;
    private int homeTeamGoals;
    private int guestTeamGoals;

    public MatchCreationDto() {
    }

}
