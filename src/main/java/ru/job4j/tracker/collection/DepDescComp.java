package ru.job4j.tracker.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String delimeter = "/";
        String[] left2 = left.split(delimeter);
        String[] right2 = right.split(delimeter);
        int rsl = right2[0].compareTo(left2[0]);
        if (rsl == 0) {
            rsl = left.compareTo(right);
        }
        return rsl;
    }
}
