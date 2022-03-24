package com.artyom.services;

import com.artyom.entities.Team;
import com.artyom.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
    private final TeamRepository repository;

    @Autowired
    public TeamService(TeamRepository repository) {
        this.repository = repository;
    }

    public Team getTeamById(Long id){
        return repository.getTeamById(id);
    }
}
