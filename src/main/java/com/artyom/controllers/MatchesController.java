package com.artyom.controllers;

import com.artyom.dto.*;
import com.artyom.entities.Match;
import com.artyom.entities.Season;
import com.artyom.services.MatchService;
import com.artyom.services.SeasonService;
import com.artyom.services.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MatchesController {

    private final MatchService matchService;
    private final TeamService teamService;
    private final SeasonService seasonService;
    private final MatchMapper matchMapper;
    private final SeasonMapper seasonMapper;

    public MatchesController(MatchService matchService, TeamService teamService, SeasonService seasonService, MatchMapper matchMapper, SeasonMapper seasonMapper) {
        this.matchService = matchService;
        this.teamService = teamService;
        this.seasonService = seasonService;
        this.matchMapper = matchMapper;
        this.seasonMapper = seasonMapper;
    }

    @GetMapping("/")
    public String index(){
        return "hello!";
    }

    @GetMapping("/{id}")
    public MatchDto showById(@PathVariable("id") Long id){
        Match match = matchService.getById(id);
        return new MatchDto(match.getId().toString(),
                match.getDate().toString(),
                seasonMapper.seasonToDto(match.getSeason()),
                match.getHomeTeam().getTeamName(),
                match.getGuestTeam().getTeamName(),
                match.getHomeTeamGoals(),
                match.getGuestTeamGoals());
    }

    @GetMapping("/all")
    public List<Match> getAll(){
        return matchService.getAll();
    }

    @GetMapping("/table/{id}")
    @ResponseBody
    public TournamentTable getTournamentTable(@PathVariable("id") Long id){
        return matchService.getTournamentTable(id);
    }

    @PostMapping("/add")
    @ResponseBody
    public MatchDto add(@RequestBody MatchCreationDto matchDto){

        Match match = matchMapper.toMatch(matchDto);
        match.setHomeTeam(teamService.getTeamById(Long.valueOf(matchDto.getHomeTeamId())));
        match.setGuestTeam(teamService.getTeamById(Long.valueOf(matchDto.getGuestTeamId())));
        match.setSeason(seasonService.getSeasonById(Long.valueOf(matchDto.getSeasonId())));

        matchService.registerMatch(match);

        return new MatchDto(match.getId().toString(),
                match.getDate().toString(),
                seasonMapper.seasonToDto(match.getSeason()),
                match.getHomeTeam().getTeamName(),
                match.getGuestTeam().getTeamName(),
                match.getHomeTeamGoals(),
                match.getGuestTeamGoals());
    }
}
