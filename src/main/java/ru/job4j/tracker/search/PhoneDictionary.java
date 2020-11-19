package ru.job4j.tracker.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private final ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> contains1 = person -> person.getAddress().equals(key);
        Predicate<Person> contains2 = person -> person.getName().equals(key);
        Predicate<Person> contains3 = person -> person.getSurname().equals(key);
        Predicate<Person> contains4 = person -> person.getPhone().equals(key);
        Predicate<Person> combine = contains1.or(contains2.or(contains3.or(contains4)));
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
