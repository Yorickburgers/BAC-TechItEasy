package nl.novi.bachwtechiteasy.controllers;

import nl.novi.bachwtechiteasy.exceptions.RecordNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/televisions")
public class TelevisionController {

    @GetMapping
    public ResponseEntity<String> getTelevisions() {
        return ResponseEntity.ok("televisions");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getTelevision(@PathVariable int id) {
        if (id == 0) { // dummy, check of database id bevat
            throw new RecordNotFoundException("television" + id + "does not exist");
        }
        else {
        return ResponseEntity.ok("television " + id);
        }
    }

    @PostMapping
    public ResponseEntity<String> postTelevision() {
        return ResponseEntity.created(null).body("television");
    }

    @PutMapping("{id}")
    public ResponseEntity<String> putTelevision(@PathVariable int id) {
        if (id == 0) { // dummy, check of database id bevat
            throw new RecordNotFoundException("television " + id + " does not exist");
        }
        else {
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTelevision(@PathVariable int id) {
        if (id == 0) { // dummy, check of database id bevat
            throw new RecordNotFoundException("television " + id + " does not exist");
        } else {
            return ResponseEntity.ok("television removed!");
        }
    }
}
