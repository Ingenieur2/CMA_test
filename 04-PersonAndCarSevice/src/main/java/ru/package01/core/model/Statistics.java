package ru.package01.core.model;

public class Statistics {
    private Long personCount;
    private Long carCount;
    private Long uniqueVendorCount;

    public Statistics(Long personCount, Long carCount, Long uniqueVendorCount) {
        this.personCount = personCount;
        this.carCount = carCount;
        this.uniqueVendorCount = uniqueVendorCount;
    }

    public Long getPersonCount() {
        return personCount;
    }

    public void setPersonCount(Long personCount) {
        this.personCount = personCount;
    }

    public Long getCarCount() {
        return carCount;
    }

    public void setCarCount(Long carCount) {
        this.carCount = carCount;
    }

    public Long getUniqueVendorCount() {
        return uniqueVendorCount;
    }

    public void setUniqueVendorCount(Long uniqueVendorCount) {
        this.uniqueVendorCount = uniqueVendorCount;
    }
}
