package fr.wizard.fantasticBeasts.FantasticBeasts;

import com.google.gson.Gson;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataBase {
    private static FantasticBeasts[] animauxFantastiques;

    public static FantasticBeasts[] getData() {
        if (animauxFantastiques == null) {
            animauxFantastiques = loadData();
        }
        return animauxFantastiques;
    }

    private static FantasticBeasts[] loadData() {
        try {
            return new Gson().fromJson(new BufferedReader(new FileReader(new ClassPathResource("static/animaux_fantastiques.json").getFile())), FantasticBeasts[].class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
