package ru.job4j.tracker.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String delimeter = ". ";
        String [] left2 = left.split(delimeter);
        String [] right2 = right.split(delimeter);
        return Integer.compare(Integer.parseInt(left2[0]), Integer.parseInt(right2[0]));;
    }
}
