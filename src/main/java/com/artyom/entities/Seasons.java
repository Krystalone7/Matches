package com.artyom.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Seasons {
    @Id
    private Long id;

    @Column
    private String seasonName;

    @Column
    private LocalDate dateTo;

    @Column
    private LocalDate dateFrom;

    public Long getId() {
        return id;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }
}
