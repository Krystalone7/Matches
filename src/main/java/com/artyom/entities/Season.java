package com.artyom.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "seasons")
public class Season implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column
    private String seasonName;

    @Column
    private LocalDate dateTo;

    @Column
    private LocalDate dateFrom;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "season")
    private List<Match> matches;

    public void addMatchToSeason(Match match){
        if (matches == null){
            matches = new ArrayList<>();
        }
        matches.add(match);
        match.setSeason(this);
    }

    public Season(String seasonName, LocalDate dateTo, LocalDate dateFrom) {
        this.seasonName = seasonName;
        this.dateTo = dateTo;
        this.dateFrom = dateFrom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    public Season() {
    }
}
