package com.artyom.services;

import com.artyom.entities.Season;
import com.artyom.entities.Team;
import com.artyom.repositories.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeasonService {
    private final SeasonRepository repository;

    @Autowired
    public SeasonService(SeasonRepository repository) {
        this.repository = repository;
    }

    public Season getSeasonById(Long id){
        return repository.getSeasonById(id);
    }
}