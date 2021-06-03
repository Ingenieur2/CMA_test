package ru.package01.core.service;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import ru.package01.core.model.PersonWithCars;
import ru.package01.core.model.Statistics;
import ru.package01.core.repository.CarRepository;
import ru.package01.core.repository.PersonRepository;

@Service
public class DbServiceAllStatisticsImpl implements DbServiceAllStatistics {

    private final CarRepository carRepository;
    private final PersonRepository personRepository;

    public DbServiceAllStatisticsImpl(CarRepository carRepository, PersonRepository personRepository) {
        this.carRepository = carRepository;
        this.personRepository = personRepository;
    }

    @Override
    public String findCarsByOwnerId(Long ownerId) {
        Gson gson = new Gson();
        if (ownerId == null) {
            return "NOT_FOUND";
        }
        if (personRepository.findById(ownerId).isPresent()) {
            PersonWithCars personWithCars = new PersonWithCars();
            personWithCars.setId(ownerId);
            personWithCars.setName(personRepository.findById(ownerId).get().getName());
            personWithCars.setBirthDate(personRepository.findById(ownerId).get().getBirthDate());
            personWithCars.setCars(carRepository.findByOwnerId(ownerId));
            return gson.toJson(personWithCars);
        } else {
            return "BAD_REQUEST";
        }
    }

    @Override
    public String getCurrentStatistics() {
        Gson gson = new Gson();
        Statistics statistics = new Statistics(
                personRepository.count(),
                carRepository.count(),
                (long) carRepository.findByModel().size());
        return gson.toJson(statistics);
    }

    @Override
    public void clear() {
        personRepository.deleteAll();
        carRepository.deleteAll();
    }
}
