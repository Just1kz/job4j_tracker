package ru.job4j.tracker.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SearchAtt {
    public static List<Attachment> filterSize(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getSize() > 100) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getName().contains("bug")) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static List<Attachment> filter(List<Attachment> list) {
        Comparator<Attachment> cmpNameSize = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment left, Attachment right) {
                return left.getName().compareTo(right.getName());
            }
        }.thenComparing(
                new Comparator<Attachment>() {
                    @Override
                    public int compare(Attachment left, Attachment right) {
                        return left.getSize() - right.getSize();
                    }
                }
        );
        list.sort(cmpNameSize);
        return list;
    }
//2. Выберите подходящий функциональный интерфейс из пакета java.util.function.
//3. Создайте универсальный метод filter(...).
}
