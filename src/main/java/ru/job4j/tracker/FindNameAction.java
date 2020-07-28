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
         ArrayList[] showAllNameSearch = tracker.findByName(name);
         if (showAllNameSearch.length > 0) {
             for (int i = 0; i < showAllNameSearch.length; i++) {
                 out.println(showAllNameSearch[i]);
             }
         } else {
             out.println("Ошибка при вводе данных, Имя заявки не существует. Требуется повторить операцию с вводом корректных данных");
         }
        return true;
    }
}
