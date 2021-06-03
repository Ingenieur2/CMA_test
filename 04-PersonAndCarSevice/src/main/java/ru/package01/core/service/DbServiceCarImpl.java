package ru.package01.core.service;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.package01.core.model.Car;
import ru.package01.core.repository.CarRepository;
import ru.package01.core.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DbServiceCarImpl implements DbServiceCar {
    private static final char SEPARATOR = '-';
    private static final Logger logger = LoggerFactory.getLogger(DbServiceCarImpl.class);

    private final CarRepository carRepository;
    private final PersonRepository personRepository;

    public DbServiceCarImpl(CarRepository carRepository, PersonRepository personRepository) {
        this.carRepository = carRepository;
        this.personRepository = personRepository;
    }

    private boolean checkModelText(String model) {
        char[] sequenceOfChars = model.toCharArray();
        int count = 0;
        if ((sequenceOfChars[0] == SEPARATOR) || (sequenceOfChars[sequenceOfChars.length - 1] == SEPARATOR)) {
            return false;
        }
        for (int i = 1; i < sequenceOfChars.length - 1; i++) {
            if (sequenceOfChars[i] == SEPARATOR) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        if (count == 0) {
            return false;
        }
        return true;
    }

    @Override
    public long saveCar(String carString) {
//--        Все поля удовлетворяют ограничениям на тип и формат
//--        модель в формате vendor-model например BMW-X5, причем vendor никогда не содержит “-” и не пустой, model не пустой),
//--        horsepower > 0
//--        ранее валидный объект с таким id не передавался
//--        существует Person с Id=ownerId
//--        данный Person старше 18 лет
        try {
            Gson gson = new Gson();
            Car car = gson.fromJson(carString, Car.class);

            AgeCalculator ageCalculator = new AgeCalculator();
            if ((carRepository.findById(car.getId()).isEmpty())
                    && (!car.getModel().equals(""))
                    && (checkModelText(car.getModel()))
                    && (car.getHorsepower() > 0)
                    && (personRepository.findById(car.getOwnerId()).isPresent())
                    && (ageCalculator.ageCalc((personRepository.findById(car.getOwnerId()).get().getBirthDate())) > 18)
            ) {
                car.setId(null);
                car.setModel(car.getModel().toUpperCase());
                carRepository.save(car);
                logger.info("created car:_____" + car);
            } else {
                car.setId(0L);
            }
            long carId = car.getId();
            return carId;
        } catch (Exception e) {
            System.out.println("DID NOT CREATE CAR");
            throw new DbServiceException(e);
        }
    }

    @Override
    public Optional<Car> getCar(long id) {
        try {
            Optional<Car> carOptional = carRepository.findById(id);
            logger.info("car: {}", carOptional.orElse(null));
            return carOptional;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return Optional.empty();
    }

    @Override
    public List<Car> getAll() {
        return (List<Car>) carRepository.findAll();
    }
}
