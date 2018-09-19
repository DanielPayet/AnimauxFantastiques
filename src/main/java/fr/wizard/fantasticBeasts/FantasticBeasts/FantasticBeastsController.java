package fr.wizard.fantasticBeasts.FantasticBeasts;

import fr.wizard.fantasticBeasts.DataBase.DataBase;
import fr.wizard.fantasticBeasts.Models.Beast;
import fr.wizard.fantasticBeasts.Models.Classification;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class FantasticBeastsController {

    @RequestMapping("/beasts")
    public List<Beast> getBeasts() {
        return DataBase.getBeasts();
    }

    @RequestMapping("/beasts/{id}")
    public Beast getBeast(@PathVariable("id") int id) {
        return DataBase.getBeast(id);
    }

    @RequestMapping("/classifications")
    public List<Classification> getClassifications() {
        return DataBase.getClassifications();
    }

    @RequestMapping("/classifications/{id}")
    public Classification getClassification(@PathVariable("id") int id) {
        return DataBase.getClassification(id);
    }

}
