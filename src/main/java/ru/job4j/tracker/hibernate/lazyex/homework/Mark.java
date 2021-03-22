package ru.job4j.tracker.hibernate.lazyex.homework;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "marks")
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "mark")
    private List<Model> model = new ArrayList<>();

    public static Mark of(String name) {
        Mark mark = new Mark();
        mark.name = name;
        return mark;
    }

    public void addModelCar(Model modelCar) {
        this.model.add(modelCar);
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

    public List<Model> getModel() {
        return model;
    }

    public void setModel(List<Model> modelCars) {
        this.model = modelCars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Mark markCar = (Mark) o;
        return id == markCar.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Mark{"
                + "id="
                + id
                + ", name='"
                + name
                + '\''
                + '}';
    }
}
