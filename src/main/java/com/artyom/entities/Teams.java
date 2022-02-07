package com.artyom.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Teams {

    @Id
    private Long id;

    @Column
    private String teamName;

    public Long getId() {
        return id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
