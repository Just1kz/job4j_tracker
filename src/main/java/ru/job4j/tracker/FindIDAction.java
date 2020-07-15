package ru.job4j.tracker;

public class FindIDAction implements UserAction{
    private final Output out;

    public FindIDAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find by Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        boolean rsl = true;
        int id = Integer.parseInt(input.askStr("Enter id: "));
         Item item = tracker.findById(id);
         if (item != null) {
             System.out.println(item);
         } else {
             System.out.println("Ошибка при вводе данных, ID не существует. Требуется повторить операцию с вводом корректных данных");
             rsl = false;
         }
        return rsl;
    }
}
