package nl.novi.bachwtechiteasy.services;

import nl.novi.bachwtechiteasy.models.Television;
import nl.novi.bachwtechiteasy.repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;

import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {

    @Autowired
    private final TelevisionRepository repos;

    @Autowired
    public TelevisionService(TelevisionRepository repos) {
        this.repos = repos;
    }

    public List<Television> getTelevisions() {
        return repos.findAll();
    }

    public Optional<Television> getTelevision(int id) {
        return repos.findById(id);
    }

    public ResponseEntity<Television> saveTelevision(Television television) {
        // dto naar entity
        //
        return ResponseEntity.ok().body(this.repos.save(television));
    }

    public ResponseEntity<Television> updateTelevision(int id, Television television) {
     Television oldTelevision = this.repos.findById(id); // find by ID // set as veriable
        oldTelevision = television;// overwrite variable with parameter data
        // save to ID?
        // return repsonseentity with new data (getbyID)
    }

    public ResponseEntity<String> deleteTelevision(int id) {
        this.repos.deleteById(id);
        return ResponseEntity.ok().body("Television deleted");
    }
}
