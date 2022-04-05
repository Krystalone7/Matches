package com.artyom.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "seasons")
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String seasonName;

    @Column
    private LocalDate dateTo;

    @Column
    private LocalDate dateFrom;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "season")
    private List<Match> matches = new ArrayList<>();

    public Season() {
    }

    public Season(String seasonName, LocalDate dateTo, LocalDate dateFrom) {
        this.seasonName = seasonName;
        this.dateTo = dateTo;
        this.dateFrom = dateFrom;
    }
}
