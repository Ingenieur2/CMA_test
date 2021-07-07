package ru.package01.core.service;

public interface DbServiceAllStatistics {
    String findCarsByOwnerId(Long ownerId);

    String getCurrentStatistics();

    void clear();
}
