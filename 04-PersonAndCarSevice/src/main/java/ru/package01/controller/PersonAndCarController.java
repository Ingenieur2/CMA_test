package ru.package01.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.package01.core.service.DbServiceAllStatistics;

@RestController
public class PersonAndCarController {
    private final DbServiceAllStatistics dbServiceAllStatistics;

    public PersonAndCarController(DbServiceAllStatistics dbServiceAllStatistics) {
        this.dbServiceAllStatistics = dbServiceAllStatistics;
    }

    @GetMapping("/personwithcars")
    public ResponseEntity<String> personWithCars(@RequestParam("personid") Long personId) {
        String result = dbServiceAllStatistics.findCarsByOwnerId(personId);
        if (result.equals("BAD_REQUEST")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else if (result.equals("NOT_FOUND")) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok().body(result);
        }
    }

    @GetMapping("/statistics")
    public String getCurrentStatistics() {
        return dbServiceAllStatistics.getCurrentStatistics();
    }

    @GetMapping("/clear")
    public void clearAllData() {
        dbServiceAllStatistics.clear();
    }
}
