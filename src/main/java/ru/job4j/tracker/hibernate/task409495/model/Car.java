package ru.job4j.tracker.hibernate.task409495.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "carX")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "engine_id", foreignKey = @ForeignKey(name = "ENGINE_ID_FK"))
    private Engine engine;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "history_owner",
            joinColumns = {
            @JoinColumn(name = "driver_id", nullable = false, updatable = false) },
            inverseJoinColumns = {
            @JoinColumn(name = "carX_id", nullable = false, updatable = false) })
    private List<Driver> driverSet = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public List<Driver> getDriverSet() {
        return driverSet;
    }

    public void setDriverSet(List<Driver> driverSet) {
        this.driverSet = driverSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return id == car.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Car{"
                + "id="
                + id
                + ", name='"
                + name
                + '\''
                + ", engine="
                + engine
                + '}';
    }
}
