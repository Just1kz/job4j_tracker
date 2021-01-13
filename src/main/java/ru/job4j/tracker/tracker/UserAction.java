package ru.job4j.tracker.tracker;

public interface UserAction {
    String name();

    boolean execute(Input input, Store tracker);
}
