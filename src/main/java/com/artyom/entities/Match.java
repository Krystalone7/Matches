package com.artyom.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@Table(name = "matches")
public class Match{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "season_id")
    private Season season;

    @Column
    private LocalDate date;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "home_team_id")
    private Team homeTeam;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "guest_team_id")
    private Team guestTeam;

    @Column
    private Integer homeTeamGoals;

    @Column
    private Integer guestTeamGoals;

    public Match(LocalDate date, int homeTeamGoals, int guestTeamGoals) {
        this.date = date;
        this.homeTeamGoals = homeTeamGoals;
        this.guestTeamGoals = guestTeamGoals;
    }

    public Match() {
    }
}
