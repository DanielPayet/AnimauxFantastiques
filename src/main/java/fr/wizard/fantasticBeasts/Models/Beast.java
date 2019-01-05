package fr.wizard.fantasticBeasts.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.wizard.fantasticBeasts.DataBase.DataBase;

import java.util.Arrays;
import java.util.List;

public class Beast implements JsonModel {
    private int id;
    private String name;
    private Integer classificationId;
    private Integer[] locationId;
    private String firstSeen;
    private String description;

    @JsonProperty("nom")
    public String getName() {
        return name;
    }

    @JsonProperty("classifications")
    public Classification getClassification() {
        if(classificationId != null){
            return DataBase.getClassification(classificationId);
        }
        return null;
    }

    @JsonProperty("habitats")
    public List<Location> getLocations() {
        if (locationId != null) {
            return DataBase.getLocations(Arrays.stream(locationId).mapToInt(Integer::intValue).toArray());
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
    public Integer getClassificationId() {
        return this.classificationId;
    }

    @JsonIgnore
    public Integer[] getLocationsId() {
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

    public void setLocationId(Integer[] locationId) {
        this.locationId = locationId;
    }

    public void setFirstSeen(String firstSeen) {
        this.firstSeen = firstSeen;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

