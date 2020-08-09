package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;

public class Tracker {
    private final ArrayList<Item> items = new ArrayList<Item>();
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items.set(size++, item);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> findName = new ArrayList<Item>();
        for (int index = 0; index < size; index++) {
            Item item = items.get(index);
            if (item.getName().equals(key)) {
                findName.add(items.get(index));
            }
        }
        return findName;
    }

    public ArrayList<Item> findAll() {
        return items;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
            if (index != -1) {
                item.setId(id);
                items.set(index, item);
            }
        return index != -1;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
        items.remove(index);
        }
        return index != -1;
    }
}

