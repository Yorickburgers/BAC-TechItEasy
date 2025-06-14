package nl.novi.bachwtechiteasy.controllers;

import nl.novi.bachwtechiteasy.dtos.TelevisionDto;
import nl.novi.bachwtechiteasy.dtos.TelevisionInputDto;
import nl.novi.bachwtechiteasy.exceptions.RecordNotFoundException;
import nl.novi.bachwtechiteasy.models.Television;
import nl.novi.bachwtechiteasy.repositories.TelevisionRepository;
import nl.novi.bachwtechiteasy.services.TelevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @GetMapping
    public ResponseEntity<List<Television>> getTelevisions() {
        List<Television> televisions = televisionService.getTelevisions();
        return ResponseEntity.ok(televisions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Television> getTelevision(@PathVariable int id) {
        Television television = televisionService.getTelevision(id);
        return ResponseEntity.ok(television);
    }

    @PostMapping
    public ResponseEntity<Television> postTelevision(@RequestBody Television television) {
    Television tv = televisionService.saveTelevision(television);

        URI uri = URI.create(
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/" + tv.getId()).toUriString());

        return ResponseEntity.created(uri).body(televisionService.saveTelevision(tv));
    }

    @PutMapping("{id}")
    public ResponseEntity<Television> putTelevision(@PathVariable int id, @RequestBody Television television) {
        return ResponseEntity.ok().body(televisionService.updateTelevision(id, television));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTelevision(@PathVariable int id) {
        return ResponseEntity.ok(televisionService.deleteTelevision(id));
    }
}
