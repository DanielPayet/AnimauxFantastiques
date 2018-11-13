package fr.wizard.fantasticBeasts.FantasticBeasts.Controller;

import fr.wizard.fantasticBeasts.DataBase.DAO.LocationDAO;
import fr.wizard.fantasticBeasts.DataBase.DataBase;
import fr.wizard.fantasticBeasts.Models.Location;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LocationsController {

    @GetMapping("/locations")
    public List<Location> getClassification() {
        return DataBase.getLocations();
    }

    @GetMapping("/locations/{id}")
    public Location getlocations(@PathVariable("id") int id) {
        return DataBase.getLocation(id);
    }

    @PostMapping("/locations")
    public ResponseEntity<Location> postLocation(@RequestBody Location newLocation) {
        return new ResponseEntity<>(LocationDAO.save(newLocation), HttpStatus.CREATED);
    }

    @PutMapping("/locations/{id}")
    public Location putLocation(@PathVariable("id") int id, @RequestBody Location updateLocation) {
        return LocationDAO.update(id, updateLocation);
    }

    @DeleteMapping("/locations/{id}")
    public ResponseEntity deleteLocation(@PathVariable("id") int id) {
        LocationDAO.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
