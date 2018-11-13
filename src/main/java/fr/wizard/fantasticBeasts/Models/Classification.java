package fr.wizard.fantasticBeasts.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Classification implements JsonModel {
    private int id;
    private String name;
    private String description;

    @JsonProperty("id")
    public int getId() {
        return id;
    }

    @JsonProperty("categorie")
    public String getName() {
        return name;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
