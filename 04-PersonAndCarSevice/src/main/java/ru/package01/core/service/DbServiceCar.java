package ru.package01.core.service;

import ru.package01.core.model.Car;

import java.util.List;
import java.util.Optional;

public interface DbServiceCar {
    long saveCar(String carString);

    Optional<Car> getCar(long id);

    List<Car> getAll();
}
