package fr.wizard.fantasticBeasts.FantasticBeasts.Controller;

import fr.wizard.fantasticBeasts.DataBase.DAO.ClassificationDAO;
import fr.wizard.fantasticBeasts.DataBase.DataBase;
import fr.wizard.fantasticBeasts.Models.Classification;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value="classifications", description="Need to know all the classification ?")
@RestController
public class ClassificationsController {

    @ApiOperation(value = "View the full list of classification", response = Iterable.class)
    @GetMapping("/classifications")
    public List<Classification> getClassification() {
        return DataBase.getClassifications();
    }

    @ApiOperation(value = "Interested in only one classification ?", response = Iterable.class)
    @GetMapping("/classifications/{id}")
    public Classification getClassification(@PathVariable("id") int id) {
        return DataBase.getClassification(id);
    }

    @ApiOperation(value = "A new level of beast has been discovered", response = Iterable.class)
    @PostMapping("/classifications")
    public ResponseEntity<Classification> postClassification(@RequestBody Classification newClassification) {
        return new ResponseEntity<>(ClassificationDAO.save(newClassification), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Need to review the classification ?", response = Iterable.class)
    @PatchMapping("/classifications/{id}")
    public Classification patchClassification(@PathVariable("id") int id, @RequestBody Classification updateClassification) {
        return ClassificationDAO.update(id, updateClassification);
    }

    @ApiOperation(value = "An entire classification disappeared ? There you go", response = Iterable.class)
    @DeleteMapping("/classifications/{id}")
    public ResponseEntity deleteClassification(@PathVariable("id") int id) {
        ClassificationDAO.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
