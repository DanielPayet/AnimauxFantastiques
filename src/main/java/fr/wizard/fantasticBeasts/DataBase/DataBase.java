package fr.wizard.fantasticBeasts.DataBase;

import com.google.gson.Gson;
import fr.wizard.fantasticBeasts.Models.Beast;
import fr.wizard.fantasticBeasts.Models.Classification;
import fr.wizard.fantasticBeasts.Models.Location;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class DataBase {
    private static Map<Integer, Beast> beasts;
    private static Map<Integer, Location> locations;
    private static Map<Integer, Classification> classifications;

    // GETTERS ---------------------------------------------

    public static Beast getBeast(int beastId) {
        return DataBase.beasts.get(beastId);
    }

    public static Location getLocation(int locationId) {
        return DataBase.locations.get(locationId);
    }

    public static Classification getClassification(int classificationId) {
        return DataBase.classifications.get(classificationId);
    }

    public static ArrayList<Beast> getBeasts() {
        return new ArrayList<>(DataBase.beasts.values());
    }

    public static ArrayList<Location> getLocations() {
        return new ArrayList<>(DataBase.locations.values());
    }

    public static ArrayList<Classification> getClassifications() {
        return new ArrayList<>(DataBase.classifications.values());
    }

    // LOAD AND SAVE ---------------------------------------

    public static void load() {
        /*
        try {
            //DataBase.beasts = new Gson().fromJson(new BufferedReader(new FileReader(new ClassPathResource("static/fantastic_beasts.json").getFile())), ArrayList<Beast>.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
    }
}
