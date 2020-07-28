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

    public ArrayList[] findByName(String key) {
        ArrayList<Item> findName = new ArrayList<Item>();
        int count = 0;
        for (int index = 0; index < size; index++) {
            Item item = items.get(index);
            if (item.getName().equals(key)) {
                findName.set(count, items.get(index));
                count += 1;
            }
        }
        return Arrays.copyOf(new ArrayList[]{findName}, count);
    }

    public ArrayList[] findAll() {
        return Arrays.copyOf(new ArrayList[]{items}, size);
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
        items.set(index, null);
        int start = index + 1;
        int distPos = index;
        int countCopy = size - index;
        System.arraycopy(items, start, items, distPos, countCopy);
        items.set(size - 1, null);
        size--;
        }
        return index != -1;
    }

}

