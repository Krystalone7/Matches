package com.artyom.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Matches {
    @Id
    private Long id;

    @Column
    private Long seasonId;

    @Column
    private LocalDate date;

    @Column
    private Long homeTeamId;

    @Column
    private Long guestTeamId;

    @Column
    private int homeTeamGoals;

    @Column
    private int guestTeamGoals;

    public void setId(Long id) {
        this.id = id;
    }

    public void setSeasonId(Long seasonId) {
        this.seasonId = seasonId;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setHomeTeamId(Long homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public void setGuestTeamId(Long guestTeamId) {
        this.guestTeamId = guestTeamId;
    }

    public void setHomeTeamGoals(int homeTeamGoals) {
        this.homeTeamGoals = homeTeamGoals;
    }

    public void setGuestTeamGoals(int guestTeamGoals) {
        this.guestTeamGoals = guestTeamGoals;
    }

    public Long getId() {
        return id;
    }

    public Long getSeasonId() {
        return seasonId;
    }

    public LocalDate getDate() {
        return date;
    }

    public Long getHomeTeamId() {
        return homeTeamId;
    }

    public Long getGuestTeamId() {
        return guestTeamId;
    }

    public int getHomeTeamGoals() {
        return homeTeamGoals;
    }

    public int getGuestTeamGoals() {
        return guestTeamGoals;
    }
}
