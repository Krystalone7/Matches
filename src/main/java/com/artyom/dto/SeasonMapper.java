package com.artyom.dto;

import com.artyom.entities.Season;
import org.springframework.stereotype.Component;

@Component
public class SeasonMapper {

    public SeasonDto seasonToDto(Season season) {
        return new SeasonDto(season.getId().toString(), season.getSeasonName());
    }
}
