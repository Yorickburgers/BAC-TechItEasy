package nl.novi.bachwtechiteasy.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/televisions")
public class TelevisionController {

    @GetMapping
    public String getTelevisions() {
        return "televisions";
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getTelevision(@PathVariable int id) {
        return ResponseEntity.ok("television " + id);
    }

    @PostMapping
    public ResponseEntity<String> postTelevision() {
        return ResponseEntity.created(null).body("television");
    }

    @PutMapping("{id}")
    public ResponseEntity<String> putTelevision(@PathVariable int id) {
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTelevision(@PathVariable int id) {
        return ResponseEntity.ok("television removed!");
    }
}
