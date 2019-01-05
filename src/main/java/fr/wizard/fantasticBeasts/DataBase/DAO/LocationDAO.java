package fr.wizard.fantasticBeasts.DataBase.DAO;

import fr.wizard.fantasticBeasts.DataBase.DataBase;
import fr.wizard.fantasticBeasts.Models.Location;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

public class LocationDAO extends DAO {
    private static String fileName = "location.json";

    public static Map<Integer, Location> load() {
        return DataBase.locations = Arrays.stream(requireNonNull(getJSON(fileName, Location[].class))).collect(Collectors.toMap(Location::getId, location -> location));
    }

    public static Location save(Location newLocation) {
        newLocation.setId(generateId());
        DataBase.locations.put(newLocation.getId(), newLocation);
        saveJson(fileName, DataBase.locations);
        return newLocation;
    }

    public static Location update(int id, Location location) {
        location.setId(id);
        mergeLocation(location);
        saveJson(fileName, DataBase.locations);
        return DataBase.locations.get(id);
    }

    public static void delete(int id) {
        DataBase.locations.remove(id);
        saveJson(fileName, DataBase.locations);
    }

    private static int generateId() {
        return DataBase.locations.get(Collections.max(DataBase.locations.keySet())).getId() + 1;
    }

    private static void mergeLocation(Location location) {
        Location old = DataBase.locations.get(location.getId());
        if (location.getName() != null) {
            old.setName(location.getName());
        }
        DataBase.locations.replace(old.getId(), old);
    }
}