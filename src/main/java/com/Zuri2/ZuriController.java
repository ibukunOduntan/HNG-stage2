package com.Zuri2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
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
    public ResponseEntity<?> createPerson(@RequestBody ZuriDTO create) {
        if (create.getName().isEmpty() || !isNonIntegerString(create.getName())) {

            ErrorMessage errorMessage = new ErrorMessage("Name must be a non-null, non-integer string!");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);

        }
        if (zuriRepo.findByName(create.getName()) != null){

                // Person not found, return an error response
                ErrorMessage errorMessage = new ErrorMessage("Person with the same name already exists");
                return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
        }

        // Create a new person with the provided name
        ZuriDomain person = new ZuriDomain();
        person.setName(create.getName());
        zuriRepo.save(person);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(person);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> readPerson(@PathVariable Long id) {

        ZuriDomain person = zuriRepo.findPersonById(id);

        if (person == null) {
                // Person not found, return an error response
                ErrorMessage errorResponse = new ErrorMessage("Person not found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }

        return ResponseEntity.ok(person);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePerson(@PathVariable Long id,  @RequestBody ZuriDTO update) {

        ZuriDomain person = zuriRepo.findPersonById(id);

        if (person == null){
            ErrorMessage errorResponse = new ErrorMessage("Person not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }

        if (update.getName().isEmpty() || !isNonIntegerString(update.getName())){
            ErrorMessage errorResponse = new ErrorMessage("Name must be a non-null, non-integer string!");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);

        }
        person.setName(update.getName());
        zuriRepo.save(person);

        ResponseMessage responseMessage = new ResponseMessage("Person updated successfully", person);

        return ResponseEntity.ok(responseMessage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable Long id){

        if (zuriRepo.findPersonById(id) == null){
            ErrorMessage errorResponse = new ErrorMessage("Person not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }

        ZuriDomain person = zuriRepo.findPersonById(id);
        zuriRepo.delete(person);
        DeleteMessage deleteMessage = new DeleteMessage("Person deleted successfully", person);

        return ResponseEntity.ok(deleteMessage);
    }

    private boolean isNonIntegerString(String str) {
        return str.matches("^[a-zA-Z\\s]+$");
    }

}
