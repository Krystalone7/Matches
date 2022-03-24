package com.artyom.repositories;

import com.artyom.entities.Season;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasonRepository extends JpaRepository<Season, Long> {
    Season getSeasonById(Long id);
}
