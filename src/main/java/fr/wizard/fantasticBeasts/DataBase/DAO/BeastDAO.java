package fr.wizard.fantasticBeasts.DataBase.DAO;

import fr.wizard.fantasticBeasts.DataBase.DataBase;
import fr.wizard.fantasticBeasts.Models.Beast;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

public class BeastDAO extends DAO {
    private static String fileName = "fantastic_beasts.json";

    public static Map<Integer, Beast> load() {
        return Arrays.stream(requireNonNull(getJSON(fileName, Beast[].class))).collect(Collectors.toMap(Beast::getId, beast -> beast));
    }

    public static Beast save(Beast newBeast) {
        newBeast.setId(generateId());
        DataBase.beasts.put(newBeast.getId(), newBeast);
        saveJson(fileName, DataBase.beasts);
        return newBeast;
    }

    public static Beast update(int id, Beast updateBeast) {
        updateBeast.setId(id);
        mergeBeast(updateBeast);
        saveJson(fileName, DataBase.beasts);
        return DataBase.beasts.get(id);
    }

    public static void delete(int id) {
        DataBase.beasts.remove(id);
        saveJson(fileName, DataBase.beasts);
    }

    private static int generateId() {
        return DataBase.beasts.get(Collections.max(DataBase.beasts.keySet())).getId() + 1;
    }

    private static void mergeBeast(Beast beast) {
        Beast old = DataBase.beasts.get(beast.getId());
        if (beast.getName() != null) {
            old.setName(beast.getName());
        }
        if (beast.getClassificationId() != null) {
            old.setClassificationId(beast.getClassificationId());
        }
        if (beast.getLocationsId() != null) {
            old.setLocationId(beast.getLocationsId());
        }
        if (beast.getFirstSeen() != null) {
            old.setFirstSeen(beast.getFirstSeen());
        }
        if (beast.getDescription() != null) {
            old.setDescription(beast.getDescription());
        }
        DataBase.beasts.replace(old.getId(), old);
    }
}
