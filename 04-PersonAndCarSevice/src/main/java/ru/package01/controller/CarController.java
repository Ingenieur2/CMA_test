package ru.package01.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.package01.core.service.DbServiceCar;

@RestController
public class CarController {

    private final DbServiceCar dbServiceCar;

    public CarController(DbServiceCar dbServiceCar) {
        this.dbServiceCar = dbServiceCar;
    }

    @PostMapping("/car")
    public ResponseEntity<String> carSave(@RequestBody String carString) {
        long id = dbServiceCar.saveCar(carString);
        if (id != 0) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
