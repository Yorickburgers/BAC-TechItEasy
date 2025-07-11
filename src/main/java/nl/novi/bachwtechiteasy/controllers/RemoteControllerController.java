package nl.novi.bachwtechiteasy.controllers;

import nl.novi.bachwtechiteasy.dtos.RemoteControllerDto;
import nl.novi.bachwtechiteasy.dtos.RemoteControllerInputDto;
import nl.novi.bachwtechiteasy.services.RemoteControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/remotes")
public class RemoteControllerController {
    @Autowired
    private final RemoteControllerService remoteControllerService;

    @Autowired
    public RemoteControllerController(RemoteControllerService remoteControllerService) {
        this.remoteControllerService = remoteControllerService;
    }

    @GetMapping
    public ResponseEntity<List<RemoteControllerDto>> getRemoteControllers() {
        return ResponseEntity.ok(remoteControllerService.getRemoteControllers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RemoteControllerDto> getRemoteController(@PathVariable Long id) {
        return ResponseEntity.ok(remoteControllerService.getRemoteController(id));
    }

    @PostMapping
    public ResponseEntity<RemoteControllerDto> postRemoteController(@RequestBody RemoteControllerInputDto remoteDto) {
        RemoteControllerDto remote = remoteControllerService.saveRemoteController(remoteDto);

        URI uri = URI.create(
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/" + remote.id).toUriString());

        return ResponseEntity.created(uri).body(remote);
    }

    @PutMapping("{id}")
    public ResponseEntity<RemoteControllerDto> putRemoteController(@PathVariable Long id, @RequestBody RemoteControllerInputDto remoteControllerDto) {
        return ResponseEntity.ok().body(remoteControllerService.updateRemoteController(id, remoteControllerDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRemoteController(@PathVariable Long id) {
        return ResponseEntity.ok(remoteControllerService.deleteRemoteController(id));
    }
}
