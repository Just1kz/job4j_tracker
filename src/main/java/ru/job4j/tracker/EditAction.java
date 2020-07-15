package ru.job4j.tracker;

public class EditAction implements UserAction{
    @Override
    public String name() {
        return "=== Edit Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        boolean rsl = true;
        int id = Integer.parseInt(input.askStr("Enter id, where are you want replace your item: "));
         String name = input.askStr("Enter name, what you want replace: ");
         Item item = new Item(name);
         if (tracker.replace(id, item)) {
             System.out.println("replaces completed");
         } else {
             System.out.println("Ошибка при вводе данных, Имя заявки или ID не существует. Требуется повторить операцию с вводом корректных данных");
             rsl = false;
         }
        return rsl;
    }
}
