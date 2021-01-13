package ru.job4j.tracker.tracker;

public class DeleteAction implements UserAction {

    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Delete Item ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        int id = Integer.parseInt(input.askStr("Enter id: "));
         if (tracker.delete(String.valueOf(id))) {
             out.println("delete completed");
         } else {
             out.println("Ошибка при вводе данных, ID не существует. "
                     + "Требуется повторить операцию с вводом корректных данных");
         }
        return true;
    }
}
