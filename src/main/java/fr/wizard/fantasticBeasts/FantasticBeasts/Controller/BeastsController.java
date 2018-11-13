package fr.wizard.fantasticBeasts.FantasticBeasts.Controller;

import fr.wizard.fantasticBeasts.DataBase.DAO.BeastDAO;
import fr.wizard.fantasticBeasts.DataBase.DataBase;
import fr.wizard.fantasticBeasts.Models.Beast;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BeastsController {

    @GetMapping("/beasts")
    public List<Beast> getBeasts() {
        return DataBase.getBeasts();
    }

    @GetMapping("/beasts/{id}")
    public Beast getBeast(@PathVariable("id") int id) {
        return DataBase.getBeast(id);
    }

    @PostMapping("/beasts")
    public ResponseEntity<Beast> postBeast(@RequestBody Beast newBeast) {
        return new ResponseEntity<>(BeastDAO.save(newBeast), HttpStatus.CREATED);
    }

    @PutMapping("/beasts/{id}")
    public Beast putBeast(@PathVariable("id") int id, @RequestBody Beast updateBeast) {
        return BeastDAO.update(id, updateBeast);
    }

    @DeleteMapping("/beasts/{id}")
    public ResponseEntity deleteBeast(@PathVariable("id") int id) {
        BeastDAO.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
