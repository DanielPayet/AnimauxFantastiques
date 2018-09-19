package fr.wizard.fantasticBeasts.Models;

import fr.wizard.fantasticBeasts.DataBase.DataBase;

public class Beast {
    private String name;
    private int classificationId;
    private int locationId;
    private String firstSeen;
    private String description;

    public String getName() {
        return this.name;
    }

    public Classification getClassification() {
        return DataBase.getClassification(this.classificationId);
    }

    public Location getHabitat() {
        return DataBase.getLocation(this.locationId);
    }

    public String getPremierApercu() {
        return this.firstSeen;
    }

    public String getDescription() {
        return this.description;
    }
}



