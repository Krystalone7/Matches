package com.artyom.services;

import com.artyom.dto.TournamentTable;
import com.artyom.entities.Match;
import com.artyom.entities.Season;

public interface MatchService {
    void registerMatch(Match match);
    TournamentTable getTournamentTable(Season season);
}
