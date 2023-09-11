package com.Zuri2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping(path = "/api")
public class ZuriController {

    private final ZuriRepo zuriRepo;

    public ZuriController(ZuriRepo zuriRepo) {
        this.zuriRepo = zuriRepo;
    }

    @PostMapping("")
    public ResponseEntity<String> createPerson(@RequestBody ZuriDTO create) {
        if (create.getName().isEmpty() || !isNonIntegerString(create.getName())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Name must be a non-null, non-integer string!");
        }
        if (zuriRepo.findByName(create.getName()) != null){
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Person with the same name already exists");
        }

        // Create a new person with the provided name
        ZuriDomain person = new ZuriDomain();
        person.setName(create.getName());
        zuriRepo.save(person);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Person, " + person.getName() + " created successfully");
    }

    @GetMapping("")
    public ResponseEntity<?> readPerson(@RequestParam (name = "name") String encodedName) {

        String name = java.net.URLDecoder.decode(encodedName, StandardCharsets.UTF_8);
        ZuriDomain person = zuriRepo.findByName(name);
        if (name.isEmpty() || !isNonIntegerString(name)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Name must be a non-null, non-integer string!");
        }

        if (person == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Person does not exist");
        }
        return ResponseEntity.ok(person);
    }

    @PutMapping("")
    public ResponseEntity<String> updatePerson(@RequestParam (name = "name") String encodedName,  @RequestBody ZuriDTO update) {

        String name = java.net.URLDecoder.decode(encodedName, StandardCharsets.UTF_8);
        if (name.isEmpty() || !isNonIntegerString(name)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Name must be a non-null, non-integer string!");
        }
        ZuriDomain person = zuriRepo.findByName(name);

        if (person == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Person does not exist");
        }

        if (update.getName().isEmpty() || !isNonIntegerString(update.getName())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Name must be a non-null, non-integer string!");

        }
        person.setName(update.getName());
        zuriRepo.save(person);

        return ResponseEntity.status(HttpStatus.OK)
                .body("Person name " + name  + " changed to " + update.getName() + " successfully");
    }

    @DeleteMapping("")
    public ResponseEntity<String> deletePerson(@RequestParam (name = "name") String encodedName){

        String name = java.net.URLDecoder.decode(encodedName, StandardCharsets.UTF_8);
        if (name.isEmpty() || !isNonIntegerString(name)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Name must be a non-null, non-integer string!");
        }

        if (zuriRepo.findByName(name) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Person does not exist");
        }

        ZuriDomain person = zuriRepo.findByName(name);
        zuriRepo.delete(person);

        return ResponseEntity.status(HttpStatus.OK)
                .body("Person name " + name  + " deleted successfully");
    }

    private boolean isNonIntegerString(String str) {
        return str.matches("^[a-zA-Z\\s]+$");
    }

}
