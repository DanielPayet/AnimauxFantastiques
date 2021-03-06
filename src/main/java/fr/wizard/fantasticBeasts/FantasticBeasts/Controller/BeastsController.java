package fr.wizard.fantasticBeasts.FantasticBeasts.Controller;

import fr.wizard.fantasticBeasts.DataBase.DAO.BeastDAO;
import fr.wizard.fantasticBeasts.DataBase.DataBase;
import fr.wizard.fantasticBeasts.Models.Beast;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Api(value="beasts", description="Participate in the beast library")
@RestController
public class BeastsController {
    @ApiOperation(value = "View the full list of beasts", response = Iterable.class)
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
    @ApiOperation(value = "Gets the beast with the id", response = Iterable.class)
    @GetMapping("/beasts/{id}")
    public Beast getBeast(@PathVariable("id") int id) {
        return DataBase.getBeast(id);
    }

    @ApiOperation(value = "Post a new beast you've discovered !", response = Iterable.class)
    @PostMapping("/beasts")
    public ResponseEntity<Beast> postBeast(@RequestBody Beast newBeast) {
        return new ResponseEntity<>(BeastDAO.save(newBeast), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Found an error on one of those mighty beasts ?", response = Iterable.class)
    @PatchMapping("/beasts/{id}")
    public ResponseEntity  patchBeast(@PathVariable("id") int id, @RequestBody Beast updateBeast) {
        if( DataBase.beasts.get(id) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(BeastDAO.update(id, updateBeast));
    }

    @ApiOperation(value = "Have you successfully killed all of them ? Good, they're now extinct and you can delete them", response = Iterable.class)
    @DeleteMapping("/beasts/{id}")
    public ResponseEntity deleteBeast(@PathVariable("id") int id) {
        BeastDAO.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
