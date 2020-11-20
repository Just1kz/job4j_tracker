package ru.job4j.tracker.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Profile {
    private int id;
    private String name;
    private Address address;

    public Profile(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public List<Address> collect(List<Profile> profiles, Predicate<Profile> predicate) {
        List<Address> rsl = profiles.stream()
                .filter(x -> x.getAddress().getCity() != null
                || x.getAddress().getStreet() !=null
                || x.getAddress().getHome() !=0
                || x.getAddress().getApartment() !=0)
                .map(Profile::getAddress)
                .collect(Collectors.toList());
        return rsl;
    }
}
