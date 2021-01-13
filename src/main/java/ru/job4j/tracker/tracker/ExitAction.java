package ru.job4j.tracker.tracker;

public class ExitAction implements UserAction {
    @Override
    public String name() {
        return "=== Exit Menu ===";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        return false;
    }
}
