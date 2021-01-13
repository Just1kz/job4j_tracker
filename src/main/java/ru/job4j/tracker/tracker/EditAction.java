package ru.job4j.tracker.tracker;

public class EditAction implements UserAction {
    private final Output out;

    public EditAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Edit Item ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        int id = Integer.parseInt(input.askStr("Enter id, where are you want replace your item: "));
         String name = input.askStr("Enter name, what you want replace: ");
         Item item = new Item(name);
         if (tracker.replace(String.valueOf(id), item)) {
             out.println("replaces completed");
         } else {
             out.println("Ошибка при вводе данных, Имя заявки или ID не существует. "
                     + "Требуется повторить операцию с вводом корректных данных");
         }
        return true;
    }
}
