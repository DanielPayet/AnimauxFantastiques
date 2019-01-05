package fr.wizard.fantasticBeasts.DataBase;

import fr.wizard.fantasticBeasts.DataBase.DAO.BeastDAO;
import fr.wizard.fantasticBeasts.DataBase.DAO.ClassificationDAO;
import fr.wizard.fantasticBeasts.DataBase.DAO.LocationDAO;
import fr.wizard.fantasticBeasts.Models.Beast;
import fr.wizard.fantasticBeasts.Models.Classification;
import fr.wizard.fantasticBeasts.Models.Location;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class DataBase {
    public static Map<Integer, Beast> beasts;
    public static Map<Integer, Location> locations;
    public static Map<Integer, Classification> classifications;

    // GETTERS ---------------------------------------------

    public static Beast getBeast(int beastId) {
        return beasts.get(beastId);
    }

    public static Location getLocation(int locationId) {
        return locations.get(locationId);
    }

    public static List<Location> getLocations(int... locationsId) {
        return Arrays.stream(locationsId).mapToObj(DataBase::getLocation).collect(Collectors.toList());
    }

    public static Classification getClassification(Integer classificationId) {
        return classifications.get(classificationId);
    }

    public static List<Beast> getBeasts() {
        return new ArrayList<>(beasts.values());
    }

    public static List<Location> getLocations() {
        return new ArrayList<>(locations.values());
    }

    public static List<Classification> getClassifications() {
        return new ArrayList<>(classifications.values());
    }

    // LOAD AND SAVE ---------------------------------------

    public static void load() {
        beasts = BeastDAO.load();
        classifications = ClassificationDAO.load();
        locations = LocationDAO.load();
    }
}