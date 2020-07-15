package ru.job4j.tracker;

public class DeleteAction implements UserAction{
    @Override
    public String name() {
        return "=== Delete Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        boolean rsl = true;
        int id = Integer.parseInt(input.askStr("Enter id: "));
         if (tracker.delete(id)) {
             System.out.println("delete completed");
         } else {
             System.out.println("Ошибка при вводе данных, ID не существует. Требуется повторить операцию с вводом корректных данных");
             rsl = false;
         }
        return rsl;
    }
}
