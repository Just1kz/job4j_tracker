package ru.job4j.tracker.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream()
                .filter(predict)
                .collect(Collectors.toList());
    }

    public static Map<String, Student> listToMap(List<Student> students){
        return students.stream()
                .collect(Collectors.toMap(Student::getSurname, x -> x, (a, b) -> a.getSurname().equals(b.getSurname()) ? a : a));
    }
}
