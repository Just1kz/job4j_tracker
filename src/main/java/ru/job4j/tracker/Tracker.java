package ru.job4j.tracker;

import java.util.List;
import java.util.ArrayList;

public class Tracker {
    private final List<Item> items = new ArrayList<>(10);
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(size++, item);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findByName(String key) {
        List<Item> findName = new ArrayList<>();
        for (int index = 0; index < size; index++) {
            Item item = items.get(index);
            if (item.getName().equals(key)) {
                findName.add(items.get(index));
            }
        }
        return findName;
    }

    public List<Item> findAll() {
        return items;
    }

    private int indexOf(int id) {
        int rsl = -1;
        if (!items.isEmpty()) {
            for (int index = 0; index < size; index++) {
                if (items.get(index).getId() == id) {
                    rsl = index;
                    break;
                }
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

