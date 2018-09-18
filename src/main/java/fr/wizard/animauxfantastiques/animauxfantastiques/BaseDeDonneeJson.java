package fr.wizard.animauxfantastiques.animauxfantastiques;

import com.google.gson.Gson;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BaseDeDonneeJson {
    private static AnimauxFantastiques[] animauxFantastiques;

    public static AnimauxFantastiques[] getDonnees() {
        if (animauxFantastiques == null) {
            animauxFantastiques = chargerDonnees();
        }
        return animauxFantastiques;
    }

    private static AnimauxFantastiques[] chargerDonnees() {
        try {
            return new Gson().fromJson(new BufferedReader(new FileReader(new ClassPathResource("static/animaux_fantastiques.json").getFile())), AnimauxFantastiques[].class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
