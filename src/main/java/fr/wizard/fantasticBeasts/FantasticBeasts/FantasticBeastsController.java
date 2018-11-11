package fr.wizard.fantasticBeasts.FantasticBeasts;

import fr.wizard.fantasticBeasts.DataBase.DataBase;
import fr.wizard.fantasticBeasts.Models.Beast;
import fr.wizard.fantasticBeasts.Models.Classification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FantasticBeastsController {

    @GetMapping("/beasts")
    public List<Beast> getBeasts() {
        return DataBase.getBeasts();
    }

    @GetMapping("/beasts/{id}")
    public Beast getBeast(@PathVariable("id") int id) {
        return DataBase.getBeast(id);
    }

    @PostMapping("/beasts")
    Beast newBeast(@RequestBody Beast newBeast) {
        return DataBase.saveBeast(newBeast);
    }

    @DeleteMapping("/beasts")
    ResponseEntity deleteBeast(@RequestBody Beast beastToDelete) {
        // Kill that freaking beast
        /*
        if( couldntDotIt ) {
            return ResponseEntity.ok(HttpStatus.CONFLICT);
        }
         */
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/classifications")
    public List<Classification> getClassifications() {
        return DataBase.getClassifications();
    }

    @GetMapping("/classifications/{id}")
    public Classification getClassification(@PathVariable("id") int id) {
        return DataBase.getClassification(id);
    }

    @GetMapping("/")
    public ResponseEntity getRoot() {
        return ResponseEntity.ok(HttpStatus.NOT_FOUND);
    }

}
