package nl.novi.bachwtechiteasy.controllers;

import nl.novi.bachwtechiteasy.exceptions.RecordNotFoundException;
import nl.novi.bachwtechiteasy.models.Television;
import nl.novi.bachwtechiteasy.repositories.TelevisionRepository;
import nl.novi.bachwtechiteasy.services.TelevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    @Autowired
    private final TelevisionService televisionService;

    @Autowired
    public TelevisionController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }

//    @GetMapping
//    public ResponseEntity<List<Television>> getTelevisions() {
//        List<Television> televisions = televisionRepository.findAll();
//        return ResponseEntity.ok(televisions);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Optional<Television>> getTelevision(@PathVariable int id) {
//        Television television = televisionRepository.findById(id);
//
//        if (television.isPresent() == false) {
//            throw new RecordNotFoundException("television" + id + "does not exist");
//        }
//        else {
//        return ResponseEntity.ok(television);
//        }
//    }
//
//    @PostMapping
//    public ResponseEntity<Television> postTelevision(@RequestBody Television television) {
//        return ResponseEntity.created(null).body(television);
//    }
//
//    @PutMapping("{id}")
//    public ResponseEntity<String> putTelevision(@PathVariable int id) {
//        Optional<Television> television = televisionRepository.findById(id);
//
//        if (television.isPresent() == false) {
//            throw new RecordNotFoundException("television " + id + " does not exist");
//        }
//        else {
//            return ResponseEntity.noContent().build();
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteTelevision(@PathVariable int id) {
//        if (id == 0) { // dummy, check of database id bevat
//            throw new RecordNotFoundException("television " + id + " does not exist");
//        } else {
//            return ResponseEntity.ok("television removed!");
//        }
//    }
}
