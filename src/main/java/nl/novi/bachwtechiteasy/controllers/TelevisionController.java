package nl.novi.bachwtechiteasy.controllers;

import nl.novi.bachwtechiteasy.dtos.IdInputDto;
import nl.novi.bachwtechiteasy.dtos.TelevisionDto;
import nl.novi.bachwtechiteasy.dtos.TelevisionInputDto;
import nl.novi.bachwtechiteasy.services.TelevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {
    private final TelevisionService televisionService;

    public TelevisionController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }

    @GetMapping
    public ResponseEntity<List<TelevisionDto>> getTelevisions() {
        return ResponseEntity.ok(televisionService.getTelevisions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelevisionDto> getTelevision(@PathVariable Long id) {
        return ResponseEntity.ok(televisionService.getTelevision(id));
    }

    @PostMapping
    public ResponseEntity<TelevisionDto> postTelevision(@RequestBody TelevisionInputDto television) {
    TelevisionDto tv = televisionService.saveTelevision(television);

        URI uri = URI.create(
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/" + tv.id).toUriString());

        return ResponseEntity.created(uri).body(tv);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelevisionDto> putTelevision(@PathVariable Long id, @RequestBody TelevisionInputDto televisionInputDto) {
        return ResponseEntity.ok().body(televisionService.updateTelevision(id, televisionInputDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTelevision(@PathVariable Long id) {
        return ResponseEntity.ok(televisionService.deleteTelevision(id));
    }

    @PutMapping("/{id}/remotecontroller")
    public ResponseEntity<TelevisionDto> assignRemoteToTelevision(@PathVariable Long id, @RequestBody IdInputDto input) {
        return ResponseEntity.ok().body(televisionService.assignRemoteControllerToTelevision(input.id, id));
    }

    @PutMapping("/{id}/cimodule")
    public ResponseEntity<TelevisionDto> assignCIModuleToTelevision(@PathVariable Long id, @RequestBody IdInputDto input) {
        return ResponseEntity.ok().body(televisionService.assignCIModuleToTelevision(input.id, id));
    }
}
