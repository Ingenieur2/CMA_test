package ru.package01.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.package01.core.service.DbServicePerson;

@RestController
public class PersonController {

    private final DbServicePerson dbServicePerson;

    public PersonController(DbServicePerson dbServicePerson) {
        this.dbServicePerson = dbServicePerson;
    }

    @PostMapping("/person")
    public ResponseEntity<String> personSave(@RequestBody String personString) {
        long id = dbServicePerson.savePerson(personString);
        if (id != 0) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
