package com.artyom.services;

import com.artyom.entities.Match;
import com.artyom.entities.Season;
import com.artyom.repositories.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    private MatchRepository matchRepository;

    @Autowired
    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public List<Match> getMatchesBySeason(Season season){
        return matchRepository.getMatchesBySeason(season);
    }

    public void registerMatch(Match match){
        matchRepository.save(match);
    }
}
