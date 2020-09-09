package ru.job4j.tracker.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        boolean a = true;
        int count = 0;
        int rsl = 0;
        List<Character> first = new ArrayList<>();
        for(Character firstInvite : left.toCharArray()) {
            first.add(firstInvite);
        }
        List<Character> second = new ArrayList<>();
        for(Character secondInvite : right.toCharArray()) {
            second.add(secondInvite);
        }
        do {
            rsl = Character.compare(first.get(count),second.get(count));
            count++;
            if (rsl != 0 || count == first.size() || count == second.size()) {
                break;
            }
        } while (a);
        return rsl;
    }
}
