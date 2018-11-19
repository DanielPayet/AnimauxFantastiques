package fr.wizard.fantasticBeasts.FantasticBeasts.Controller;

import fr.wizard.fantasticBeasts.DataBase.DAO.BeastDAO;
import fr.wizard.fantasticBeasts.DataBase.DataBase;
import fr.wizard.fantasticBeasts.Models.Beast;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class BeastsController {

    @GetMapping("/beasts")
    public List<Beast> getBeasts(@RequestParam(value = "location", required = false) String location, @RequestParam(value = "category", required = false) String category) {
        List<Beast> beasts = DataBase.getBeasts();
        if (location != null) {
            int locationId = DataBase.getLocations().stream().filter(locationDataBase -> locationDataBase.getName().toString().equals(location)).findFirst().get().getId();
            beasts = beasts.stream().filter((beast -> beast.getLocations() != null)).filter(beast -> Arrays.stream(beast.getLocationsId()).anyMatch(id -> id == locationId)).collect(Collectors.toList());
        }
        if (category != null) {
            beasts = beasts.stream().filter((beast -> beast.getClassification() != null)).filter(beast -> beast.getClassification().getName().toString().equals(category)).collect(Collectors.toList());
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
