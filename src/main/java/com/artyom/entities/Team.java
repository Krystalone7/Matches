package com.artyom.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String teamName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "homeTeam")
    private List<Match> homeTeamMatches;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "guestTeam")
    private List<Match> guestTeamMatches;

    public void addMatchToHomeTeam(Match match){
        if (homeTeamMatches == null){
            homeTeamMatches = new ArrayList<>();
        }
        homeTeamMatches.add(match);
        match.setHomeTeam(this);
    }

    public void addMatchToGuestTeam(Match match){
        if (guestTeamMatches == null){
            guestTeamMatches = new ArrayList<>();
        }
        guestTeamMatches.add(match);
        match.setHomeTeam(this);
    }

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public Team() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<Match> getHomeTeamMatches() {
        return homeTeamMatches;
    }

    public void setHomeTeamMatches(List<Match> homeTeamMatches) {
        this.homeTeamMatches = homeTeamMatches;
    }

    public List<Match> getGuestTeamMatches() {
        return guestTeamMatches;
    }

    public void setGuestTeamMatches(List<Match> guestTeamMatches) {
        this.guestTeamMatches = guestTeamMatches;
    }

}
