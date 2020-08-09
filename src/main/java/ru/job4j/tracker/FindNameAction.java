package ru.job4j.tracker;

import java.util.ArrayList;

public class FindNameAction implements UserAction{
    private final Output out;

    public FindNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find by Name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
         String name = input.askStr("Enter name to search: ");
         ArrayList<Item> showAllNameSearch = tracker.findByName(name);
         if (showAllNameSearch.size() > 0) {
             for (int i = 0; i < showAllNameSearch.size(); i++) {
                 out.println(showAllNameSearch.get(i));
             }
         } else {
             out.println("Ошибка при вводе данных, Имя заявки не существует. Требуется повторить операцию с вводом корректных данных");
         }
        return true;
    }
}
