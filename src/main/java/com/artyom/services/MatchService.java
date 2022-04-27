package com.artyom.services;

import com.artyom.dto.TournamentTable;
import com.artyom.entities.Match;
import com.artyom.entities.Season;

import java.util.List;

public interface MatchService {
    Match registerMatch(Match match);
    TournamentTable getTournamentTable(Long id);
    Match getById(Long id);
    List<Match> getAll();
}
