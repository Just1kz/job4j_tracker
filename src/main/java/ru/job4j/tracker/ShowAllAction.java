package ru.job4j.tracker;

import java.util.List;

public class ShowAllAction implements UserAction {

    @Override
    public String name() {
        return "=== Show all items ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        List<Item> showAll = tracker.findAll();
         if (showAll.size() > 0) {
             for (Item item : showAll) {
                 System.out.println(item);
             }
         } else {
             System.out.println("Store is empty.");
         }
        return true;
    }
}
