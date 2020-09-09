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
        int lim = Math.min(left2.length, right2.length);
        int z = 0;
        for (int x = 0; x < lim; x++) {
           if (!left2[x].equals(right2[x])) {
               z = Integer.compare(Integer.parseInt(left2[x]), Integer.parseInt(right2[x]));
               break;
           }
        }
        return z;
    }
}
