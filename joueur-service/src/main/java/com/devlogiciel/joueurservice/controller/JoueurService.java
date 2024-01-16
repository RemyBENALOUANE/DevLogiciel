package com.devlogiciel.joueurservice.controller;

import com.devlogiciel.joueurservice.model.Joueur;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Api(tags = "Joueur API", description = "Microservice joueur")
public class JoueurService {
    private final List<Joueur> joueurs = generateJoueurs();

    private List<Joueur> generateJoueurs() {
        List<Joueur> joueurList = new ArrayList<>();
        joueurList.add(new Joueur(1, "Payet", 1));
        joueurList.add(new Joueur(2, "Harit", 1));
        joueurList.add(new Joueur(3, "Clauss", 1));
        joueurList.add(new Joueur(4, "Gigot", 1));
        joueurList.add(new Joueur(5, "Mbemba", 1));

        joueurList.add(new Joueur(6, "Mbappe", 2));
        joueurList.add(new Joueur(7, "Zaire-Emery", 2));
        joueurList.add(new Joueur(8, "Dembele", 2));
        joueurList.add(new Joueur(9, "Lee Kang-In", 2));
        joueurList.add(new Joueur(10, "Marquinhos", 2));

        joueurList.add(new Joueur(11, "Wahi", 3));
        joueurList.add(new Joueur(12, "Samba", 3));
        joueurList.add(new Joueur(13, "Danso", 3));
        joueurList.add(new Joueur(14, "Machado", 3));
        joueurList.add(new Joueur(15, "Sotoca", 3));

        joueurList.add(new Joueur(16, "Lacazette", 4));
        joueurList.add(new Joueur(17, "Cherki", 4));
        joueurList.add(new Joueur(18, "O'Brien", 4));
        joueurList.add(new Joueur(19, "Tagliafico", 4));
        joueurList.add(new Joueur(20, "Lopes", 4));

        joueurList.add(new Joueur(21, "Todibo", 5));
        joueurList.add(new Joueur(22, "Thuram", 5));
        joueurList.add(new Joueur(23, "Beka beka", 5));
        joueurList.add(new Joueur(24, "Rosario", 5));
        joueurList.add(new Joueur(25, "Sanson", 5));

        return joueurList;

    }

    @GetMapping(value = "/getJoueurs")
    @ApiOperation(value = "Get all joueurs", response = List.class)
    public List<Joueur> getJoueurs() {
        return this.joueurs;
    }

    @GetMapping(value = "/getJoueur/{id}")
    @ApiOperation(value = "Get joueur by id", response = List.class)
    public List<Joueur> getEquipeById(@PathVariable(value = "id") Integer id) {
        return joueurs.stream()
                .filter(s -> s.getId().equals(id))
                .collect(Collectors.toList());
    }

    @PostMapping(value = "/addJoueur")
    @ApiOperation(value = "Add a new joueur", response = String.class)
    public String addEquipe(@RequestBody Joueur nouveauJoueur) {
        joueurs.add(nouveauJoueur);
        return "Joueur ajouté avec succès";
    }

    @PutMapping(value = "/updateJoueur/{id}")
    @ApiOperation(value = "Update joueur information", response = String.class)
    public String updateJoueur(@PathVariable(value = "id") Integer id, @RequestBody Joueur joueurMisAJour) {
        List<Joueur> joueurToUpdate = joueurs.stream()
                .filter(e -> e.getId().equals(id))
                .collect(Collectors.toList());

        if (!joueurToUpdate.isEmpty()) {
            Joueur equipeExistante = joueurToUpdate.get(0);

            equipeExistante.setName(joueurMisAJour.getName());

            return "Informations du joueur mises à jour avec succès";
        } else {
            return "Aucun joueur trouvé avec l'ID fourni";
        }
    }

    @DeleteMapping(value = "/deleteJoueur/{id}")
    @ApiOperation(value = "Delete joueur by id", response = String.class)
    public String deleteJoueur(@PathVariable(value = "id") Integer id) {
        Iterator<Joueur> iterator = joueurs.iterator();
        boolean equipeFound = false;

        while (iterator.hasNext()) {
            Joueur equipe = iterator.next();
            if (equipe.getId().equals(id)) {
                iterator.remove();
                equipeFound = true;
                break;
            }
        }

        if (equipeFound) {
            return "Joueur supprimé avec succès";
        } else {
            return "Aucun joueur trouvé avec l'ID fourni";
        }
    }
}
