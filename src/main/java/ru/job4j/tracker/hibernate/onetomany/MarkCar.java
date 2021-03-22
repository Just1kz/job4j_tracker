package ru.job4j.tracker.hibernate.onetomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "markCar")
public class MarkCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ModelCar> modelCars = new ArrayList<>();

    public static MarkCar of(String name) {
        MarkCar markCar = new MarkCar();
        markCar.name = name;
        return markCar;
    }

    public void addModelCar(ModelCar modelCar) {
        this.modelCars.add(modelCar);
    }

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

    public List<ModelCar> getModelCars() {
        return modelCars;
    }

    public void setModelCars(List<ModelCar> modelCars) {
        this.modelCars = modelCars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MarkCar markCar = (MarkCar) o;
        return id == markCar.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "MarkCar{"
                + "id="
                + id
                + ", name='"
                + name
                + '\''
                + ", modelCars="
                + modelCars
                + '}';
    }
}
