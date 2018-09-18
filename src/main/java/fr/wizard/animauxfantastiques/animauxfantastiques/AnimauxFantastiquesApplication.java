package fr.wizard.animauxfantastiques.animauxfantastiques;

import com.google.gson.Gson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@SpringBootApplication
public class AnimauxFantastiquesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimauxFantastiquesApplication.class, args);
        AnimauxFantastiques[] animauxFantastiques = null;
        try {
            animauxFantastiques = new Gson().fromJson(new BufferedReader(new FileReader(new ClassPathResource("static/animaux_fantastiques.json").getFile())), AnimauxFantastiques[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("animauxFantastiques = " + animauxFantastiques[0].getNom());
	}
}
