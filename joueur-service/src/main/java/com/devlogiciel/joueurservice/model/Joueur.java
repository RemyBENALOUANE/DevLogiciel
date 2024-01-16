package com.devlogiciel.joueurservice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Joueur details")
public class Joueur {

    @ApiModelProperty(notes = "L'id du joueur")
    private Integer id;

    @ApiModelProperty(notes = "Le nom du joueur")
    private String name;

    @ApiModelProperty(notes = "L'id de l'équipe à laquelle il appartient")
    private Integer equipeId;

    public Joueur() {

    }
    public Joueur(Integer id, String name, Integer equipeId) {
        this.id = id;
        this.name = name;
        this.equipeId = equipeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEquipeId() {
        return equipeId;
    }

    public void setEquipeId(Integer equipeId) {
        this.equipeId = equipeId;
    }
}
