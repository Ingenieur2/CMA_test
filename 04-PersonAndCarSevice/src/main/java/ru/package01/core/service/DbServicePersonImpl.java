package ru.package01.core.service;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.package01.core.model.Person;
import ru.package01.core.repository.PersonRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class DbServicePersonImpl implements DbServicePerson {
    public static final String DATE_FORMAT = "dd-MM-yyyy";
    private static final Logger logger = LoggerFactory.getLogger(DbServicePersonImpl.class);

    private final PersonRepository personRepository;

    public DbServicePersonImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public long savePerson(String personString) {
//        Все поля удовлетворяют ограничениям на тип и формат

//        Дата рождения в прошлом
//        Дата рождения в нужном формате
//        Ранее валидный объект с таким id не передавался

        try {
            Gson gson = new Gson();
            Person person = gson.fromJson(personString, Person.class);
            if (!(person.getId() == 0)
                    && (!personRepository.findById(person.getId()).isPresent())
                    && (!person.getName().equals(""))
                    && (person.getBirthDate().toString().equals(""))
                    && (LocalDate.now().isBefore(person.getBirthDate()))
                    && (person.getBirthDate().toString().equals(person.getBirthDate().format(DateTimeFormatter.ofPattern(DATE_FORMAT))))

            ) {
                personRepository.save(person);
                logger.info("created person:_____");
            }

            long personId = person.getId();
            logger.info("created person: {}", personId);
            return personId;
        } catch (Exception e) {
            System.out.println("DID NOT CREATE PERSON");
            throw new DbServiceException(e);
        }
    }

    @Override
    public Optional<Person> getPerson(long id) {
        try {
            Optional<Person> personOptional = personRepository.findById(id);
            logger.info("person: {}", personOptional.orElse(null));
            return personOptional;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return Optional.empty();
    }

    @Override
    public List<Person> getAll() {
        return (List<Person>) personRepository.findAll();
    }
}
