package nl.novi.bachwtechiteasy.controllers;

import nl.novi.bachwtechiteasy.dtos.TelevisionDto;
import nl.novi.bachwtechiteasy.dtos.TelevisionInputDto;
import nl.novi.bachwtechiteasy.services.TelevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

public class WallBracketController {
    @Autowired
    private final WallBracketService wallBracketService;

    @Autowired
    public WallbracketController(WallBracketService wallBracketService) {
        this.wallBracketService = wallBracketService;
    }

    @GetMapping
    public ResponseEntity<List<WallBracketDto>> getWallBrackets() {
        return ResponseEntity.ok(wallBracketService.getWallBrackets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WallBracketDto> getWallbracket(@PathVariable int id) {
        return ResponseEntity.ok(wallBracketService.getWallBracket(id));
    }

    @PostMapping
    public ResponseEntity<WallBracketDto> postWallBracket(@RequestBody WallBracketInputDto wallBracket) {
        WallBracketDto wb = wallBracketService.saveWallBracket(wallBracket);

        URI uri = URI.create(
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/" + wb.id).toUriString());

        return ResponseEntity.created(uri).body(wb);
    }

    @PutMapping("{id}")
    public ResponseEntity<WallBracketDto> putWallBracket(@PathVariable int id, @RequestBody WallBracketInputDto wallBracketInputDto) {
        return ResponseEntity.ok().body(wallBracketService.updateWallBracket(id, wallBracketInputDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWallbracket(@PathVariable int id) {
        return ResponseEntity.ok(wallBracketService.deleteWallBracket(id));
    }
}
