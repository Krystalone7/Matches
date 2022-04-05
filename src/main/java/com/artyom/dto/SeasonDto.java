package com.artyom.dto;

import lombok.Getter;

@Getter
public class SeasonDto {

    private final String id;
    private final String seasonName;

    public SeasonDto(String id, String seasonName) {
        this.id = id;
        this.seasonName = seasonName;
    }
}
