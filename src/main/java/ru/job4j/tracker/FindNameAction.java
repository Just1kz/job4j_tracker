package ru.job4j.tracker;

public class FindNameAction implements UserAction{
    @Override
    public String name() {
        return "=== Find by Name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
         boolean rsl = true;
         String name = input.askStr("Enter name to search: ");
         Item[] showAllNameSearch = tracker.findByName(name);
         if (showAllNameSearch.length > 0) {
             for (int i = 0; i < showAllNameSearch.length; i++) {
                 System.out.println(showAllNameSearch[i]);
             }
         } else {
             System.out.println("Ошибка при вводе данных, Имя заявки не существует. Требуется повторить операцию с вводом корректных данных");
             rsl = false;
         }
        return rsl;
    }
}
