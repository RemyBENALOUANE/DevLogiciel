package com.devlogiciel.matchservice.controller;

import com.devlogiciel.matchservice.model.Match;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Api(tags = "Match API", description = "Microservice match")
public class MatchService {

    private final List<Match> matchs = generateMatchs();

    private List<Match> generateMatchs() {
        List<Match> matchList = new ArrayList<>();
        matchList.add(new Match(1, 1, 2));
        matchList.add(new Match(2, 1, 3));
        matchList.add(new Match(3, 1, 4));
        matchList.add(new Match(4, 1, 5));
        matchList.add(new Match(5, 2, 3));
        matchList.add(new Match(6, 2, 4));
        matchList.add(new Match(7, 2, 5));
        matchList.add(new Match(8, 3, 4));
        matchList.add(new Match(9, 3, 5));
        matchList.add(new Match(10, 4, 5));

        return matchList;
    }

    @GetMapping(value = "/getMatchs")
    @ApiOperation(value = "Get all matchs", response = List.class)
    public List<Match> getMatchs() {
        return this.matchs;
    }

    @GetMapping(value = "/getMatch/{id}")
    @ApiOperation(value = "Get match by id", response = List.class)
    public List<Match> getMatchById(@PathVariable(value = "id") Integer id) {
        return matchs.stream()
                .filter(s -> s.getId().equals(id))
                .collect(Collectors.toList());
    }

    @PostMapping(value = "/addMatch")
    @ApiOperation(value = "Add a new match", response = String.class)
    public String addMatch(@RequestBody Match nouveauMatch) {
        matchs.add(nouveauMatch);
        return "Match ajouté avec succès";
    }

    @PutMapping(value = "/updateMatch/{id}")
    @ApiOperation(value = "Update match information", response = String.class)
    public String updateMatch(@PathVariable(value = "id") Integer id, @RequestBody Match matchMiseAJour) {
        List<Match> matchsToUpdate = matchs.stream()
                .filter(m -> m.getId().equals(id))
                .collect(Collectors.toList());

        if (!matchsToUpdate.isEmpty()) {
            Match matchExistant = matchsToUpdate.get(0);

            matchExistant.setEquipe1(matchMiseAJour.getEquipe1());
            matchExistant.setEquipe2(matchMiseAJour.getEquipe2());

            return "Informations du match mises à jour avec succès";
        } else {
            return "Aucun match trouvé avec l'ID fourni";
        }
    }

    @DeleteMapping(value = "/deleteMatch/{id}")
    @ApiOperation(value = "Delete match by id", response = String.class)
    public String deleteMatch(@PathVariable(value = "id") Integer id) {
        Iterator<Match> iterator = matchs.iterator();
        boolean matchFound = false;

        while (iterator.hasNext()) {
            Match match = iterator.next();
            if (match.getId().equals(id)) {
                iterator.remove();
                matchFound = true;
                break;
            }
        }

        if (matchFound) {
            return "Match supprimé avec succès";
        } else {
            return "Aucun match trouvé avec l'ID fourni";
        }
    }
}
