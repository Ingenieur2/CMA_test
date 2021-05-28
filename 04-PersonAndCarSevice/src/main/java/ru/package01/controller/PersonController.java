package ru.package01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.package01.core.model.Car;
import ru.package01.core.service.DbServicePerson;

import java.util.List;

@RestController
public class PersonController {

    private final DbServicePerson dbServicePerson;

    @Autowired
    public PersonController(DbServicePerson dbServicePerson) {
        this.dbServicePerson = dbServicePerson;
    }

    @PostMapping("/person")
        public void personSave(String personString) {
        long id = dbServicePerson.savePerson(personString);
//        if (id != 0) {
//            return new ResponseEntity<>(HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
    }
//    public ResponseEntity<?> personSave(String personString) {
//        long id = dbServicePerson.savePerson(personString);
//        if (id != 0) {
//            return new ResponseEntity<>(HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
}
