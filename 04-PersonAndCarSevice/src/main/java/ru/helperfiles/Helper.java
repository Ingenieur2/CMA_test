package ru.helperfiles;

import com.google.gson.Gson;
import ru.package01.core.model.Car;
import ru.package01.core.model.Person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Helper {
    public static void main(String[] args) {
        Person person = new Person();
        person.setId(3L);
        person.setName("Fil");
        person.setBirthDate(LocalDate.now());
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        System.out.println();
        Gson gson = new Gson();
        String str = gson.toJson(person);
        System.out.println(str);

        HelperPersonNew helperPersonNew = new HelperPersonNew();
        helperPersonNew.setId(3);
        helperPersonNew.setName("Fil");
        Date fff = new Date();
        helperPersonNew.setBirthDate(fff);
//personNew.setBirthDate(Jun 1, 2021, 10:41:10 PM);
        str = gson.toJson(helperPersonNew);
        System.out.println(str);
//        System.out.println(personNew.getBirthDate());

        Car car = new Car();
        car.setId(2L);
        car.setModel("UAZ-469");
        car.setHorsepower(83);
        car.setOwnerId(1L);
        str = gson.toJson(car);
        System.out.println(str);
    }
}
