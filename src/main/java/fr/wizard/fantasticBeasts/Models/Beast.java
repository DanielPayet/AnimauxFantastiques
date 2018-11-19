package fr.wizard.fantasticBeasts.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.wizard.fantasticBeasts.DataBase.DataBase;

import java.util.List;

public class Beast implements JsonModel {
    private int id;
    private String name;
    private int classificationId;
    private int[] locationId;
    private String firstSeen;
    private String description;

    @JsonProperty("nom")
    public String getName() {
        return name;
    }

    @JsonProperty("classifications")
    public Classification getClassification() {
        return DataBase.getClassification(classificationId);
    }

    @JsonProperty("habitats")
    public List<Location> getLocations() {
        if (locationId != null) {
            return DataBase.getLocations(locationId);
        }
        return null;
    }

    @JsonProperty("apparition")
    public String getFirstSeen() {
        return firstSeen;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("id")
    public int getId() {
        return id;
    }

    @JsonIgnore
    public int getClassificationId() {
        return this.classificationId;
    }

    @JsonIgnore
    public int[] getLocationsId() {
        return this.locationId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClassificationId(int classificationId) {
        this.classificationId = classificationId;
    }

    public void setLocationId(int[] locationId) {
        this.locationId = locationId;
    }

    public void setFirstSeen(String firstSeen) {
        this.firstSeen = firstSeen;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

