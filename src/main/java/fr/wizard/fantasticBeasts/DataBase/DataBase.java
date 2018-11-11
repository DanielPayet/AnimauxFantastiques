package fr.wizard.fantasticBeasts.DataBase;

import com.google.gson.Gson;
import fr.wizard.fantasticBeasts.Models.Beast;
import fr.wizard.fantasticBeasts.Models.Classification;
import fr.wizard.fantasticBeasts.Models.Location;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class DataBase {
    private static Map<Integer, Beast> beasts;
    private static Map<Integer, Location> locations;
    private static Map<Integer, Classification> classifications;

    // GETTERS ---------------------------------------------

    public static Beast getBeast(int beastId) {
        return DataBase.beasts.get(beastId);
    }

    // No idea how to save to the json file, what are those json annotation ?
    public static Beast saveBeast(Beast newBeast) {
        // Set ID
        // Save in json
        return newBeast;
    }

    public static Location getLocation(int locationId) {
        return DataBase.locations.get(locationId);
    }

    public static List<Location> getLocations(int... locationsId) {
        return Arrays.stream(locationsId).mapToObj(DataBase::getLocation).collect(Collectors.toList());
    }

    public static Classification getClassification(int classificationId) {
        return DataBase.classifications.get(classificationId);
    }

    public static List<Beast> getBeasts() {
        return new ArrayList<>(DataBase.beasts.values());
    }

    public static List<Location> getLocations() {
        return new ArrayList<>(DataBase.locations.values());
    }

    public static List<Classification> getClassifications() {
        return new ArrayList<>(DataBase.classifications.values());
    }

    // LOAD AND SAVE ---------------------------------------

    public static void load() {
        DataBase.beasts = new HashMap<>();
        DataBase.locations = new HashMap<>();
        DataBase.classifications = new HashMap<>();

        DataBase.beasts = Arrays.stream(getJSON("static/fantastic_beasts.json", Beast[].class)).collect(Collectors.toMap(Beast::getId, beast -> beast));
        DataBase.locations = Arrays.stream(getJSON("static/location.json", Location[].class)).collect(Collectors.toMap(Location::getId, location -> location));
        DataBase.classifications = Arrays.stream(getJSON("static/classification.json", Classification[].class)).collect(Collectors.toMap(Classification::getId, classification -> classification));
    }

    private static <T> T getJSON(String path, Class<T> className) {
        try {
            return new Gson().fromJson(new BufferedReader(new FileReader(new ClassPathResource(path).getFile())), className);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
