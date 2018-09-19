package fr.wizard.fantasticBeasts.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location implements JsonModel{
    private int id;
    private String name;
    private String description;

    @JsonProperty("nom")
    public String getName() {
        return this.name;
    }

    @JsonProperty("description")
    public String getDescription() {
        return this.description;
    }

    @JsonProperty("id")
    public int getId() {
        return id;
    }
}
