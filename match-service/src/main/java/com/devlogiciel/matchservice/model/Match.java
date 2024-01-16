package com.devlogiciel.matchservice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Match details")
public class Match {

    @ApiModelProperty(notes = "L'id du match")
    private Integer id;

    @ApiModelProperty(notes = "L'id de l'équipe 1")
    private Integer equipe1;

    @ApiModelProperty(notes = "L'id de l'équipe 2")
    private Integer equipe2;

    public Match() {

    }

    public Match(Integer id, Integer equipe1, Integer equipe2) {
        this.id = id;
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEquipe1() {
        return equipe1;
    }

    public void setEquipe1(Integer equipe1) {
        this.equipe1 = equipe1;
    }

    public Integer getEquipe2() {
        return equipe2;
    }

    public void setEquipe2(Integer equipe2) {
        this.equipe2 = equipe2;
    }
}
