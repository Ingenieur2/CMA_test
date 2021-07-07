package ru.package01.core.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.package01.core.model.Car;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

    @Query("select distinct model from \"cars\"")
    List<String> findByModel();

    @Query("select * from \"cars\" where owner_id = :owner_id")
    List<Car> findByOwnerId(@Param("owner_id") long owner_id);
}
