package ru.job4j.tracker;

import java.util.ArrayList;

public class ShowAllAction implements UserAction{

    @Override
    public String name() {
        return "=== Show all items ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        ArrayList[] showAll = tracker.findAll();
         if (showAll.length > 0) {
             for (int i = 0; i < showAll.length; i++) {
                 System.out.println(showAll[i]);
             }
         } else {
             System.out.println("Store is empty.");
         }
        return true;
    }
}
