package fr.wizard.fantasticBeasts.FantasticBeasts;

import fr.wizard.fantasticBeasts.DataBase.DataBase;
import fr.wizard.fantasticBeasts.Models.Beast;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
public class FantasticBeastsController {

    @RequestMapping("/animals")
    public ArrayList<Beast> getBeasts() {
        return DataBase.getBeasts();
    }

    @RequestMapping("/animal")
    public Beast getAnimalByName(@RequestParam(value = "name", defaultValue = "") String name) {
        if (!name.equals("")) {
            return DataBase.getBeasts().stream().filter((Beast beast) -> beast.getName().equals(name)).findFirst().get();
        }
        return null;
    }

}
