package ru.package01.core.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersonWithCars {

    private long id;
    private String name;
    private LocalDate birthDate;
    private List<Car> cars = new ArrayList();

    public PersonWithCars() {

    }

    public PersonWithCars(long id, String name, LocalDate birthDate, List<Car> cars) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.cars = cars;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
