package fr.wizard.fantasticBeasts.FantasticBeasts.Controller;

import fr.wizard.fantasticBeasts.DataBase.DAO.LocationDAO;
import fr.wizard.fantasticBeasts.DataBase.DataBase;
import fr.wizard.fantasticBeasts.Models.Location;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value="locations", description="Get the location of the world")
@RestController
public class LocationsController {

    @ApiOperation(value = "View the locations of the beasts", response = Iterable.class)
    @GetMapping("/locations")
    public List<Location> getClassification() {
        return DataBase.getLocations();
    }

    @ApiOperation(value = "Get a specific location", response = Iterable.class)
    @GetMapping("/locations/{id}")
    public Location getlocations(@PathVariable("id") int id) {
        return DataBase.getLocation(id);
    }

    @ApiOperation(value = "Encountered a new location in your trip ?", response = Iterable.class)
    @PostMapping("/locations")
    public ResponseEntity<Location> postLocation(@RequestBody Location newLocation) {
        return new ResponseEntity<>(LocationDAO.save(newLocation), HttpStatus.CREATED);
    }

    @ApiOperation(value = "If a location changed name, it's there", response = Iterable.class)
    @PatchMapping("/locations/{id}")
    public Location patchLocation(@PathVariable("id") int id, @RequestBody Location updateLocation) {
        return LocationDAO.update(id, updateLocation);
    }

    @ApiOperation(value = "If a location has been destroyed by something, someone and something else, delete it", response = Iterable.class)
    @DeleteMapping("/locations/{id}")
    public ResponseEntity deleteLocation(@PathVariable("id") int id) {
        LocationDAO.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
