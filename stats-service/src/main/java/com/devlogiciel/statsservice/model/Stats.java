package com.devlogiciel.statsservice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Stats details")
public class Stats {

    @ApiModelProperty(notes = "L'id de la stat")
    private Integer id;

    @ApiModelProperty(notes = "L'id de l'equipe")
    private Integer equipeId;

    @ApiModelProperty(notes = "Nombre de points de l'equipe")
    private Integer points;

    @ApiModelProperty(notes = "Nombre de victoires de l'equipe")
    private Integer nbVictoires;

    @ApiModelProperty(notes = "Nombre de defaites de l'equipe")
    private Integer nbDefaites;

    @ApiModelProperty(notes = "L'id du joueur")
    private Integer joueurId;

    @ApiModelProperty(notes = "Nombre de buts marqués par le joueur")
    private Integer nbButs;

    public Stats() {

    }

    public Stats(Integer id, Integer joueurId, Integer nbButs) {
        this.id = id;
        this.joueurId = joueurId;
        this.nbButs = nbButs;
    }

    public Stats(Integer id, Integer equipeId, Integer points, Integer nbVictoires, Integer nbDefaites) {
        this.id = id;
        this.equipeId = equipeId;
        this.points = points;
        this.nbVictoires = nbVictoires;
        this.nbDefaites = nbDefaites;
    }

    public Integer getJoueurId() {
        return joueurId;
    }

    public void setJoueurId(Integer joueurId) {
        this.joueurId = joueurId;
    }

    public Integer getNbButs() {
        return nbButs;
    }

    public void setNbButs(Integer nbButs) {
        this.nbButs = nbButs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEquipeId() {
        return equipeId;
    }

    public void setEquipeId(Integer equipeId) {
        this.equipeId = equipeId;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getNbVictoires() {
        return nbVictoires;
    }

    public void setNbVictoires(Integer nbVictoires) {
        this.nbVictoires = nbVictoires;
    }

    public Integer getNbDefaites() {
        return nbDefaites;
    }

    public void setNbDefaites(Integer nbDefaites) {
        this.nbDefaites = nbDefaites;
    }
}
