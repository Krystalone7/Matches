package com.artyom.repositories;

import com.artyom.entities.Match;
import com.artyom.entities.Season;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchRepository extends JpaRepository<Match, Long> {
    List<Match> getMatchesBySeason(Season season);
}
