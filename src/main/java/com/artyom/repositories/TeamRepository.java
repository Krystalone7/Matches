package com.artyom.repositories;

import com.artyom.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
    Team getTeamById(Long id);
}
