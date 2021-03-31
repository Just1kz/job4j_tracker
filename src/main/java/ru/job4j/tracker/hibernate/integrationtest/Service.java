package ru.job4j.tracker.hibernate.integrationtest;

import java.util.Collection;

public interface Service {

    public Order save(Order order);

    public Collection<Order> findAll();

    public Order findById(int id);

    public Order findByName(String name);

    public Order update(Order order);
}
