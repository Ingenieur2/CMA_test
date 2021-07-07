package ru.package01.core.service;

import ru.package01.core.model.Person;

import java.util.List;
import java.util.Optional;

public interface DbServicePerson {
    long savePerson(String personString);

    Optional<Person> getPerson(long id);

    List<Person> getAll();
}
