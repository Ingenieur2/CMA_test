package ru.package01.core.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.package01.core.model.Person;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    @Query("select * from \"persons\" where name = :name")
    List<Person> findByName(@Param("name") String name);
}
