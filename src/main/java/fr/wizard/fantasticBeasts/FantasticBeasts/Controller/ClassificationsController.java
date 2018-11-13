package fr.wizard.fantasticBeasts.FantasticBeasts.Controller;

import fr.wizard.fantasticBeasts.DataBase.DAO.ClassificationDAO;
import fr.wizard.fantasticBeasts.DataBase.DataBase;
import fr.wizard.fantasticBeasts.Models.Classification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClassificationsController {

    @GetMapping("/classifications")
    public List<Classification> getClassification() {
        return DataBase.getClassifications();
    }

    @GetMapping("/classifications/{id}")
    public Classification getClassification(@PathVariable("id") int id) {
        return DataBase.getClassification(id);
    }

    @PostMapping("/classifications")
    public ResponseEntity<Classification> postClassification(@RequestBody Classification newClassification) {
        return new ResponseEntity<>(ClassificationDAO.save(newClassification), HttpStatus.CREATED);
    }

    @PutMapping("/classifications/{id}")
    public Classification putClassification(@PathVariable("id") int id, @RequestBody Classification updateClassification) {
        return ClassificationDAO.update(id, updateClassification);
    }

    @DeleteMapping("/classifications/{id}")
    public ResponseEntity deleteClassification(@PathVariable("id") int id) {
        ClassificationDAO.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
