package ru.package01.core.service;

import ru.package01.core.model.Student;

import java.util.List;
import java.util.Optional;

public interface DbServiceStudent {
    long saveStudent(String studentString);

    long updateStudent(String studentString);

    Optional<Student> getStudent(long id);

    List<Student> getAll();

    long deleteStudent(String studentString);
}
