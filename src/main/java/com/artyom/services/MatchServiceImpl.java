package com.artyom.services;

import com.artyom.dto.Position;
import com.artyom.dto.TeamMapper;
import com.artyom.dto.TournamentTable;
import com.artyom.entities.Match;
import com.artyom.entities.Season;
import com.artyom.entities.Team;
import com.artyom.repositories.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MatchServiceImpl implements MatchService{

    private final MatchRepository matchRepository;
    private final TeamMapper teamMapper;

    @Autowired
    public MatchServiceImpl(MatchRepository matchRepository, TeamMapper teamMapper) {
        this.matchRepository = matchRepository;
        this.teamMapper = teamMapper;
    }

    @Override
    public TournamentTable getTournamentTable(Long id) {
        List<Match> matches = matchRepository.getMatchesBySeasonId(id);
        Set<Team> teams = new HashSet<>();
        TournamentTable tournamentTable = new TournamentTable();
        for (Match match: matches){

            Position positionHome;
            //Если ранее комнада не встречалась
            if (!teams.contains(match.getHomeTeam())){
                teams.add(match.getHomeTeam());
                positionHome = new Position(teamMapper.teamToDto(match.getHomeTeam()));
                tournamentTable.addPositionToTable(positionHome);
            }
            //Если встречалась ищем эту позицию
            else{
                List<Position> positions= tournamentTable.getTable().stream()
                        .filter(position -> position.getTeamDto().getTeamName().equals(match.getHomeTeam().getTeamName()))
                        .collect(Collectors.toList());
                System.out.println(positions);
                positionHome = positions.get(0);
            }

            Position positionGuest;
            if (!teams.contains(match.getGuestTeam())){
                teams.add(match.getGuestTeam());
                positionGuest = new Position(teamMapper.teamToDto(match.getGuestTeam()));
                tournamentTable.addPositionToTable(positionGuest);
            }
            else{
                List<Position> positions = tournamentTable.getTable().stream()
                        .filter(position -> position.getTeamDto().getTeamName().equals(match.getGuestTeam().getTeamName()))
                        .collect(Collectors.toList());
                System.out.println(positions);
                positionGuest = positions.get(0);
            }
            positionHome.incGamesCount();
            positionGuest.incGamesCount();
            if (match.getGuestTeamGoals() > match.getHomeTeamGoals()){
                positionGuest.updateScore(3);
            }
            else if (match.getGuestTeamGoals() < match.getHomeTeamGoals()){
                positionHome.updateScore(3);
            }
            else{
                positionGuest.updateScore(1);
                positionHome.updateScore(1);
            }


        }
        return tournamentTable;
    }

    @Override
    public Match registerMatch(Match match){
        return matchRepository.saveAndFlush(match);
    }

    @Override
    public Match getById(Long id) {
        return matchRepository.getMatchById(id);
    }

    @Override
    public List<Match> getAll() {
        return matchRepository.findAll();
    }
}
