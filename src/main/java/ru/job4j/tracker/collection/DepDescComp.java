package ru.job4j.tracker.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String delimeter = "/";
        String[] left2 = left.split(delimeter);
        String[] right2 = right.split(delimeter);
        int rsl = right2[0].compareTo(left2[0]);
        if (rsl ==0) {
            rsl =left.compareTo(right);
        }
//        int min = Math.min(left2.length, right2.length);
//        int rsl = 0;
//        if (!left2[0].isEmpty() || !right2[0].isEmpty()) {
//            for (int i = 0; i < min; i++) {
//                rsl = right2[i].compareTo(left2[i]);
//                if (i >=1 && right2[i-1].compareTo(left2[i-1]) == 0) {
//                    rsl = left2[i].compareTo(right2[i]);
//                }
//            }
//        } else {
//            rsl = right.compareTo(left);
//        }
        return rsl;
    }
}
