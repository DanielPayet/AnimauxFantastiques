package fr.wizard.fantasticBeasts.Models;

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
    public Classification getClassificationsId() {
        return DataBase.getClassification(classificationId);
    }

    @JsonProperty("habitats")
    public List<Location> getLocationId() {
        if(locationId != null){
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

    public void setId(int id) {
        this.id = id;
    }
}



