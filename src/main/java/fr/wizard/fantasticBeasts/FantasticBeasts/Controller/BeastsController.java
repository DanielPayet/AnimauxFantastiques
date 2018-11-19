package fr.wizard.fantasticBeasts.FantasticBeasts.Controller;

import fr.wizard.fantasticBeasts.DataBase.DAO.BeastDAO;
import fr.wizard.fantasticBeasts.DataBase.DataBase;
import fr.wizard.fantasticBeasts.Models.Beast;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BeastsController {

    @GetMapping("/beasts")
    public List<Beast> getBeasts(@RequestParam(value = "locationId", required = false) Integer locationId, @RequestParam(value = "categoryId", required = false) Integer categoryId) {
        List<Beast> beasts = DataBase.getBeasts();
        if(locationId != null) {
            beasts = beasts.stream().filter(beast -> {
                //int[] locationIds = beast.getLocationsId();
                // foreach(int locaId : locationIds)
                //{ return locaId == locationId }
                return true;
            }).collect(Collectors.toList());
        }
        if(categoryId != null) { // Test in case beasts is already emtpy ? What is it ?
            beasts = beasts.stream().filter(beast -> beast.getClassificationId() == categoryId).collect(Collectors.toList());
        }
        return beasts;
    }

    @GetMapping("/beasts/{id}")
    public Beast getBeast(@PathVariable("id") int id) {
        return DataBase.getBeast(id);
    }

    @PostMapping("/beasts")
    public ResponseEntity<Beast> postBeast(@RequestBody Beast newBeast) {
        return new ResponseEntity<>(BeastDAO.save(newBeast), HttpStatus.CREATED);
    }

    @PatchMapping("/beasts/{id}")
    public Beast patchBeast(@PathVariable("id") int id, @RequestBody Beast updateBeast) {
        return BeastDAO.update(id, updateBeast);
    }

    @DeleteMapping("/beasts/{id}")
    public ResponseEntity deleteBeast(@PathVariable("id") int id) {
        BeastDAO.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
