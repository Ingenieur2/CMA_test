package ru.package01.core.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Table("cars")
public class Car {
    @Id
    @Column("id")
    private long id;
    @Column("model")
    private String model;
    @Column("horsepower")
    private Integer horsepower;
    @Column("owner_id")
    private Long ownerId;


    public Car() {
    }

    @PersistenceConstructor
    public Car(long id, String model, Integer horsepower, Long ownerId) {
        this.id = id;
        this.model = model;
        this.horsepower = horsepower;
        this.ownerId = ownerId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(Integer horsepower) {
        this.horsepower = horsepower;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", horsepower='" + horsepower + '\'' +
                ", owner_id='" + ownerId + '\'' +
                '}';
    }
}