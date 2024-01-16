package com.devlogiciel.equipeservice.controller;

import com.devlogiciel.equipeservice.model.Equipe;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Api(tags = "Equipe API", description = "Microservice equipe")
public class EquipeService {
    private final List<Equipe> equipes = generateEquipes();

    private List<Equipe> generateEquipes() {
        List<Equipe> equipeList = new ArrayList<>();
        equipeList.add(new Equipe(1, "OM"));
        equipeList.add(new Equipe(2, "PSG"));
        equipeList.add(new Equipe(3, "Lens"));
        equipeList.add(new Equipe(4, "Lyon"));
        equipeList.add(new Equipe(5, "Nice"));

        return equipeList;
    }

    @GetMapping(value = "/getEquipes")
    @ApiOperation(value = "Get all equipes", response = List.class)
    public List<Equipe> getEquipes() {
        return this.equipes;
    }

    @GetMapping(value = "/getEquipe/{id}")
    @ApiOperation(value = "Get equipe by id", response = List.class)
    public List<Equipe> getEquipeById(@PathVariable(value = "id") Integer id) {
        return equipes.stream()
                .filter(s -> s.getId().equals(id))
                .collect(Collectors.toList());
    }

    @PostMapping(value = "/addEquipe")
    @ApiOperation(value = "Add a new equipe", response = String.class)
    public String addEquipe(@RequestBody Equipe nouvelleEquipe) {
        equipes.add(nouvelleEquipe);
        return "Equipe ajoutée avec succès";
    }

    @PutMapping(value = "/updateEquipe/{id}")
    @ApiOperation(value = "Update equipe information", response = String.class)
    public String updateEquipe(@PathVariable(value = "id") Integer id, @RequestBody Equipe equipeMiseAJour) {
        List<Equipe> equipeToUpdate = equipes.stream()
                .filter(e -> e.getId().equals(id))
                .collect(Collectors.toList());

        if (!equipeToUpdate.isEmpty()) {
            Equipe equipeExistante = equipeToUpdate.get(0);

            equipeExistante.setName(equipeMiseAJour.getName());

            return "Informations de l'équipe mises à jour avec succès";
        } else {
            return "Aucune équipe trouvée avec l'ID fourni";
        }
    }

    @DeleteMapping(value = "/deleteEquipe/{id}")
    @ApiOperation(value = "Delete equipe by id", response = String.class)
    public String deleteEquipe(@PathVariable(value = "id") Integer id) {
        Iterator<Equipe> iterator = equipes.iterator();
        boolean equipeFound = false;

        while (iterator.hasNext()) {
            Equipe equipe = iterator.next();
            if (equipe.getId().equals(id)) {
                iterator.remove();
                equipeFound = true;
                break;
            }
        }

        if (equipeFound) {
            return "Équipe supprimée avec succès";
        } else {
            return "Aucune équipe trouvée avec l'ID fourni";
        }
    }


}
