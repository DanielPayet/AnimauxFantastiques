package fr.wizard.fantasticBeasts.FantasticBeasts;

import fr.wizard.fantasticBeasts.DataBase.DataBase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class FantasticBeastsController {

    @RequestMapping("/animaux")
    public FantasticBeasts[] getAll() {
        return DataBase.getData();
    }

    @RequestMapping("/animal")
    public FantasticBeasts getAnimalByName(@RequestParam(value = "nom", defaultValue = "") String nom) {
        if (!nom.equals("")) {
            return Arrays.stream(DataBase.getData()).filter((FantasticBeasts fantasticBeasts) -> fantasticBeasts.getNom().equals(nom)).findFirst().get();
        }
        return null;
    }

}