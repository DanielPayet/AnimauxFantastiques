package fr.wizard.fantasticBeasts.DataBase;

import com.google.gson.Gson;
import fr.wizard.fantasticBeasts.FantasticBeasts.FantasticBeast;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataBase {
    private static FantasticBeast[] animauxFantastiques;

    public static FantasticBeast[] getData() {
        if (animauxFantastiques == null) {
            animauxFantastiques = loadData();
        }
        return animauxFantastiques;
    }

    private static FantasticBeast[] loadData() {
        try {
            return new Gson().fromJson(new BufferedReader(new FileReader(new ClassPathResource("static/fantastic_beasts.json").getFile())), FantasticBeast[].class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
