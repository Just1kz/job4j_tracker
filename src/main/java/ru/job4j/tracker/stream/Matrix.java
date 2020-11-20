package ru.job4j.tracker.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Matrix {
    public static void main(String[] args) {
        List<List<Integer>> matrix = List.of(
                List.of(8, 2, 5),
                List.of(9, 4, 7)
        );
        List<Integer> rsl = matrix.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println(rsl);
    }
}
