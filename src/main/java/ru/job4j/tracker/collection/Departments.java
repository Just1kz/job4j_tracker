package ru.job4j.tracker.collection;

import java.util.*;

public class Departments {
    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                start = start + el + "/";
                String rsl = start.substring(0, start.length() - 1);
                tmp.add(rsl);
            }
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList("k1", "k2", "k1/sk1", "k2/sk2", "k2/sk1");
        Departments.sortAsc(input);
        System.out.println(input);
        Departments.sortDesc(input);
        System.out.println(input);
    }

}
