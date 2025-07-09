package nl.novi.bachwtechiteasy.controllers;

import nl.novi.bachwtechiteasy.dtos.CIModuleDto;
import nl.novi.bachwtechiteasy.dtos.CIModuleInputDto;
import nl.novi.bachwtechiteasy.services.CIModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/ci-modules")
public class CIModuleController {
    @Autowired
    private final CIModuleService ciModuleService;

    @Autowired
    public CIModuleController(CIModuleService ciModuleService) {
        this.ciModuleService = ciModuleService;
    }

    @GetMapping
    public ResponseEntity<List<CIModuleDto>> getCIModules() {
        return ResponseEntity.ok(ciModuleService.getCIModules());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CIModuleDto> getCIModule(@PathVariable Long id) {
        return ResponseEntity.ok(ciModuleService.getCIModule(id));
    }

    @PostMapping
    public ResponseEntity<CIModuleDto> postCIModules(@RequestBody CIModuleInputDto ciModule) {
        CIModuleDto ci = ciModuleService.saveCIModule(ciModule);

        URI uri = URI.create(
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/" + ci.id).toUriString());

        return ResponseEntity.created(uri).body(ci);
    }

    @PutMapping("{id}")
    public ResponseEntity<CIModuleDto> putCIModule(@PathVariable Long id, @RequestBody CIModuleInputDto ciModuleInputDto) {
        return ResponseEntity.ok().body(ciModuleService.updateCIModule(id, ciModuleInputDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCIModule(@PathVariable Long id) {
        return ResponseEntity.ok(ciModuleService.deleteCIModule(id));
    }
}
