package com.artyom.controllers;

import com.artyom.dto.MatchMapper;
import com.artyom.dto.SeasonDto;
import com.artyom.dto.SeasonMapper;
import com.artyom.entities.Season;
import com.artyom.services.SeasonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SeasonsController {
    private final SeasonService seasonService;
    private final SeasonMapper mapper;

    public SeasonsController(SeasonService seasonService, SeasonMapper seasonMapper) {
        this.seasonService = seasonService;
        this.mapper = seasonMapper;
    }

    @GetMapping("/seasons")
    @ResponseBody
    public List<SeasonDto> getSeasons(){
        List<SeasonDto> seasonDto = new ArrayList<>();
        for (Season season: seasonService.getAll()){
            seasonDto.add(mapper.seasonToDto(season));
        }
        return seasonDto;
    }
}
