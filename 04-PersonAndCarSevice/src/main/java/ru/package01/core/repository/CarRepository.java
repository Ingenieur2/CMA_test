package ru.package01.core.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.package01.core.model.Car;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

    @Query("select * from \"cars\" where model = :model")
    List<Car> findByModel(@Param("model") String model);
}
