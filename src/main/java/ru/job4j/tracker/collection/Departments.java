package ru.job4j.tracker.collection;

import java.util.*;

public class Departments {
    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        Set<String> tmp2 = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                start = start + el + "/";
                tmp.add(start);
            }
        }
        for (String rsl : tmp) {
            String s = rsl.substring(0, rsl.length() - 1);
            tmp2.add(s);
        }
        return new ArrayList<>(tmp2);
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
