package ru.package01.core.service;

import java.time.LocalDate;

public class AgeCalculator {

    public int ageCalc(LocalDate birthDate) {
        LocalDate today = LocalDate.now();
        int deltaYears = today.getYear() - birthDate.getYear();
        if (today.equals(birthDate.plusYears(deltaYears))
                || today.isAfter(birthDate.plusYears(deltaYears))
        ) {
            return deltaYears;
        }
        return deltaYears - 1;
    }
}
