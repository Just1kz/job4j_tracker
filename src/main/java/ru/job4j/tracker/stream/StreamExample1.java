package ru.job4j.tracker.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample1 {
    public static void main(String[] args) {
        List<Integer> start = Arrays.asList(-5,0,3,7,-1,-10,9,-15);
        List<Integer> rsl = start.stream().filter(number -> number > 0).collect(Collectors.toList());
        System.out.println(start);
        System.out.println(rsl);
    }
}
