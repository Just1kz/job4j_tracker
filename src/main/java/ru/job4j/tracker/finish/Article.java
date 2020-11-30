package ru.job4j.tracker.finish;

import java.util.Arrays;
import java.util.HashSet;

public class Article {
    public static boolean generateBy(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" |\\p{P}");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>(Arrays.asList(origin));
        for (String fin : text) {
            if (!check.contains(fin)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
