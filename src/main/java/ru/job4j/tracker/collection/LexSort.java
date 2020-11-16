package ru.job4j.tracker.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String delimeter = ". ";
        String[] left2 = left.split(delimeter);
        String[] right2 = right.split(delimeter);
        return Integer.compare(Integer.parseInt(left2[0]), Integer.parseInt(right2[0]));
    }
}
