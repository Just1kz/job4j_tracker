package ru.job4j.tracker.tracker;

import java.util.List;
import java.util.ArrayList;

public class MemTracker implements Store {
    private final List<Item> items = new ArrayList<>(10);
    private int ids = 1;
    private int size = 0;

    @Override
    public void init() {
    }

    public Item add(Item item) {
        item.setId(ids++);
        items.add(size++, item);
        return item;
    }

    public Item findById(Integer id) {
        return id <= items.size() && !items.isEmpty() ? items.get(id) : null;
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

    private int indexOf(String id) {
        int rsl = -1;
        if (!items.isEmpty()) {
            for (int index = 0; index < size; index++) {
                if (items.get(index).getId().equals(id)) {
                    rsl = index;
                    break;
                }
            }
        }
        return rsl;
    }

    public boolean replace(Integer id, Item item) {
            if (id < items.size()) {
                item.setId(id);
                items.set(id, item);
                return true;
            }
        return false;
    }

    public boolean delete(Integer id) {
        //int index = indexOf(id);
        if (id != -1) {
        items.remove(id);
        }
        return id != -1;
    }

    public List<Item> getItems() {
        return items;
    }

    @Override
    public void close() throws Exception {
    }
}

