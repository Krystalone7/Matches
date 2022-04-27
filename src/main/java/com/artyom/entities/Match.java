package com.artyom.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.time.LocalDate;
import org.hibernate.annotations.CascadeType;

import static org.hibernate.annotations.CascadeType.SAVE_UPDATE;

@Entity
@Setter
@Getter
@Table(name = "matches")
public class Match{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @Cascade(SAVE_UPDATE)
    @JoinColumn(name = "season_id")
    private Season season;

    @Column
    private LocalDate date;

    @ManyToOne
    @Cascade(SAVE_UPDATE)
    @JoinColumn(name = "home_team_id")
    private Team homeTeam;

    @ManyToOne
    @Cascade(SAVE_UPDATE)
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

    public Match(Season season, LocalDate date, Team homeTeam, Team guestTeam, Integer homeTeamGoals, Integer guestTeamGoals) {
        this.season = season;
        this.date = date;
        this.homeTeam = homeTeam;
        this.guestTeam = guestTeam;
        this.homeTeamGoals = homeTeamGoals;
        this.guestTeamGoals = guestTeamGoals;
    }

    public Match() {
    }
}
