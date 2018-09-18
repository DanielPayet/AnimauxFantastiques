package fr.wizard.animauxfantastiques.animauxfantastiques;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class AnimauxFantastiquesControlleur {

    @RequestMapping("/animaux")
    public AnimauxFantastiques[] getAll() {
        return BaseDeDonneeJson.getDonnees();
    }

    @RequestMapping("/animal")
    public AnimauxFantastiques getAnimalByName(@RequestParam(value = "nom", defaultValue = "") String nom) {
        if (!nom.equals("")) {
            return Arrays.stream(BaseDeDonneeJson.getDonnees()).filter((AnimauxFantastiques animauxFantastiques) -> animauxFantastiques.getNom().equals(nom)).findFirst().get();
        }
        return null;
    }

}
