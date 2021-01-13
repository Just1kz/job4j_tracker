package ru.job4j.tracker.tracker;

import java.util.Objects;

public class FindIDAction implements UserAction {
    private final Output out;

    public FindIDAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find by Id ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        int id = Integer.parseInt(input.askStr("Enter id: "));
         Item item = tracker.findById(String.valueOf(id));
        out.println(Objects.requireNonNullElse(item, "Ошибка при вводе данных, ID не существует. "
                + "Требуется повторить операцию с вводом корректных данных"));
        return true;
    }
}
