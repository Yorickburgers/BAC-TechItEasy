package nl.novi.bachwtechiteasy.controllers;

import nl.novi.bachwtechiteasy.dtos.WallBracketDto;
import nl.novi.bachwtechiteasy.dtos.WallBracketInputDto;
import nl.novi.bachwtechiteasy.services.WallBracketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/wall-brackets")
public class WallBracketController {
    private final WallBracketService wallBracketService;

    public WallBracketController(WallBracketService wallBracketService) {
        this.wallBracketService = wallBracketService;
    }

    @GetMapping
    public ResponseEntity<List<WallBracketDto>> getWallBrackets() {
        return ResponseEntity.ok(wallBracketService.getWallBrackets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WallBracketDto> getWallbracket(@PathVariable Long id) {
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
    public ResponseEntity<WallBracketDto> putWallBracket(@PathVariable Long id, @RequestBody WallBracketInputDto wallBracketInputDto) {
        return ResponseEntity.ok().body(wallBracketService.updateWallBracket(id, wallBracketInputDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWallBracket(@PathVariable Long id) {
        return ResponseEntity.ok(wallBracketService.deleteWallBracket(id));
    }
}
