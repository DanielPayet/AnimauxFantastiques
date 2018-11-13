package fr.wizard.fantasticBeasts.DataBase.DAO;

import fr.wizard.fantasticBeasts.DataBase.DataBase;
import fr.wizard.fantasticBeasts.Models.Classification;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

public class ClassificationDAO extends DAO {
    private static String filePath = "static/classification.json";

    public static Map<Integer, Classification> load() {
        return Arrays.stream(requireNonNull(getJSON(filePath, Classification[].class))).collect(Collectors.toMap(Classification::getId, classification -> classification));
    }

    public static Classification save(Classification newClassification) {
        newClassification.setId(generateId());
        DataBase.classifications.put(newClassification.getId(), newClassification);
        saveJson(filePath, DataBase.classifications);
        return newClassification;
    }

    public static Classification update(int id, Classification classification) {
        classification.setId(id);
        mergeClassification(classification);
        saveJson(filePath, DataBase.classifications);
        return DataBase.classifications.get(id);
    }

    public static void delete(int id) {
        DataBase.classifications.remove(id);
        saveJson(filePath, DataBase.classifications);
    }

    private static int generateId() {
        return DataBase.classifications.get(Collections.max(DataBase.classifications.keySet())).getId() + 1;
    }

    private static void mergeClassification(Classification classification) {
        Classification old = DataBase.classifications.get(classification.getId());
        if (classification.getName() != null) {
            old.setName(classification.getName());
        }
        if (classification.getDescription() != null)
            old.setDescription(classification.getDescription());
        DataBase.classifications.replace(old.getId(), old);
    }
}