package ru.job4j.tracker.collection;

import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String orG : origin) {
            check.add(orG);
        }
        for (String fin: text) {
            if (!check.contains(fin)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
