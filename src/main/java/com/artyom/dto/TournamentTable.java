package com.artyom.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.aop.PointcutAdvisor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class TournamentTable {

    private List<Position> table = new ArrayList<>();

    public void addPositionToTable(Position position){
        table.add(position);
    }
}
