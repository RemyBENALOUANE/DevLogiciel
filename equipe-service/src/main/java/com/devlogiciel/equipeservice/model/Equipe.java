package com.devlogiciel.equipeservice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Equipe details")
public class Equipe {

    @ApiModelProperty(notes = "L'id de l'equipe")
    private Integer id;
    @ApiModelProperty(notes = "Le nom de l'equipe")
    private String name;

    public Equipe() {
    }

    public Equipe(Integer id, String name) {
        this.id = id;
        this.name = name;
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
}
