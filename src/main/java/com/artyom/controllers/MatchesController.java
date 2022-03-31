package com.artyom.controllers;

import com.artyom.dto.Mapper;
import com.artyom.dto.MatchCreationDto;
import com.artyom.dto.TournamentTable;
import com.artyom.entities.Match;
import com.artyom.entities.Season;
import com.artyom.services.MatchService;
import com.artyom.services.SeasonService;
import com.artyom.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MatchesController {

    private final MatchService matchService;
    private final TeamService teamService;
    private final SeasonService seasonService;
    private final Mapper mapper;

    @Autowired
    public MatchesController(MatchService matchService, TeamService teamService, SeasonService seasonService, Mapper mapper) {
        this.matchService = matchService;
        this.teamService = teamService;
        this.seasonService = seasonService;
        this.mapper = mapper;
    }

    @GetMapping("/")
    public String index(){
        return "hello!";
    }

    @GetMapping("/{id}")
    public Match showById(@PathVariable("id") Long id){
        return matchService.getById(id);
    }

    @GetMapping("/all")
    public List<Match> getAll(){
        return matchService.getAll();
    }

    @GetMapping("/table")
    @ResponseBody
    public TournamentTable getTournamentTable(Season season){
        return matchService.getTournamentTable(season);
    }

    @PostMapping("/add")
    @ResponseBody
    public Match add(@RequestBody MatchCreationDto matchDto){

        Match match = mapper.toMatch(matchDto);
        match.setHomeTeam(teamService.getTeamById(Long.valueOf(matchDto.getHomeTeamId())));
        match.setGuestTeam(teamService.getTeamById(Long.valueOf(matchDto.getGuestTeamId())));
        match.setSeason(seasonService.getSeasonById(Long.valueOf(matchDto.getSeasonId())));

        matchService.registerMatch(match);
        return match;
    }
}
