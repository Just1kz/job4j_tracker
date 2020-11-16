package ru.job4j.tracker;

import java.util.List;

public class FindNameAction implements UserAction {
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
         List<Item> showAllNameSearch = tracker.findByName(name);
         if (showAllNameSearch.size() > 0) {
             for (Item allNameSearch : showAllNameSearch) {
                 out.println(allNameSearch);
             }
         } else {
             out.println("Ошибка при вводе данных, Имя заявки не существует. "
                     + "Требуется повторить операцию с вводом корректных данных");
         }
        return true;
    }
}
