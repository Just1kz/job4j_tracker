package ru.job4j.tracker.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {
    public static List<Attachment> filterSize(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getSize() > 100) {
                rsl.add(att);
            }
        }
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.equals("Size");
            }
        };
        String trigger = "else";
        return SearchAtt.filter(rsl, predicate, trigger);
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getName().contains("bug")) {
                rsl.add(att);
            }
        }
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.equals("Name");
            }
        };
        String trigger = "Name";
        return SearchAtt.filter(rsl, predicate, trigger);
    }

    public static List<Attachment> filter(List<Attachment> list, Predicate<String> predicate, String trigger) {
        if (predicate.test(trigger)) {
            Comparator<Attachment> cmpName = new Comparator<Attachment>() {
                @Override
                public int compare(Attachment left, Attachment right) {
                    return left.getName().compareTo(right.getName());
                }
            };
            list.sort(cmpName);
        } else  {
            Comparator<Attachment> cmpSize =  new Comparator<Attachment>() {
                @Override
                public int compare(Attachment left, Attachment right) {
                    return left.getSize() - right.getSize();
                }
            };
            list.sort(cmpSize);
        }
        return list;
    }
}
