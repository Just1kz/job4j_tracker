package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class ShowAllAction implements UserAction{

    @Override
    public String name() {
        return "=== Show all items ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        List<Item> showAll = tracker.findAll();
         if (showAll.size() > 0) {
             for (int i = 0; i < showAll.size(); i++) {
                 System.out.println(showAll.get(i));
             }
         } else {
             System.out.println("Store is empty.");
         }
        return true;
    }
}
