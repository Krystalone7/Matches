package com.artyom.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teams")
@Getter
@Setter
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

    /*public void addMatchToHomeTeam(Match match){
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
    }*/

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public Team() {
    }
}
