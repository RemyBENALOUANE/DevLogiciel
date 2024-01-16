package com.devlogiciel.statsservice.controller;

import com.devlogiciel.statsservice.model.Stats;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Api(tags = "Stats API", description = "Microservice stats")
public class StatsService {

    private final List<Stats> stats = generateStats();

    private List<Stats> generateStats(){
        List<Stats> statsList = new ArrayList<>();
        // ---- Stats après une journéee ----
        // Victoire de l'équipe 1 (OM)
        statsList.add(new Stats(1, 1, 3, 1, 0));

        // Défaite de l'équipe 2 (PSG)
        statsList.add(new Stats(2, 2, 0, 0, 1));

        // Victoire de l'équipe 3 (Lens)
        statsList.add(new Stats(3, 3, 3, 1, 0));

        // Défaite de l'équipe 4 (Lyon)
        statsList.add(new Stats(4, 4, 0, 0, 1));

        // Match nul pour l'équipe 5 (Nice)
        statsList.add(new Stats(5, 5, 1, 0, 0));

        statsList.add(new Stats(6, 1, 2));

        return statsList;
    }

    @GetMapping(value = "/getStats")
    @ApiOperation(value = "Get all stats", response = List.class)
    public List<Stats> getStats() {
        return this.stats;
    }

    @GetMapping(value = "/getStatsEquipe/{equipeId}")
    @ApiOperation(value = "Get stats by equipeId", response = List.class)
    public List<Stats> getStatsByEquipeId(@PathVariable(value = "teamId") Integer equipeId) {
        return stats.stream()
                .filter(stats -> stats.getEquipeId().equals(equipeId))
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/getStatsJoueur/{joueurId}")
    @ApiOperation(value = "Get stats by joueurId", response = List.class)
    public List<Stats> getStatsByJoueurId(@PathVariable(value = "id") Integer id) {
        return stats.stream()
                .filter(s -> s.getId().equals(id))
                .collect(Collectors.toList());
    }
}
