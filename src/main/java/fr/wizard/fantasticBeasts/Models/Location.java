package fr.wizard.fantasticBeasts.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location implements JsonModel {
    private int id;
    private String name;

    @JsonProperty("nom")
    public String getName() {
        return this.name;
    }

    @JsonProperty("id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
