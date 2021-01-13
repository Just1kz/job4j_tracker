package ru.job4j.tracker.tracker;

import java.util.Comparator;

public class SortByNameDsc implements Comparator<Item> {
    @Override
    public int compare(Item first, Item second) {
        return second.getName().compareTo(first.getName());
    }
}
