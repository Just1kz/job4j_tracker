package ru.job4j.tracker.stream;

import java.util.ArrayList;
import java.util.Comparator;
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
                .filter(x -> x.getAddress() != null)
                .map(Profile::getAddress)
                .sorted(Comparator.comparing(Address::getCity))
                .distinct()
                .collect(Collectors.toList());
        return rsl;
    }
}
