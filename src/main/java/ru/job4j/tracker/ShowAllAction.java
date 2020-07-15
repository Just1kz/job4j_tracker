package ru.job4j.tracker;

public class ShowAllAction implements UserAction{
    private final Output out;

    public ShowAllAction(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "=== Show all items ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] showAll = tracker.findAll();
         if (showAll.length > 0) {
             for (int i = 0; i < showAll.length; i++) {
                 out.println(showAll[i]);
             }
         } else {
             out.println("Store is empty.");
         }
        return true;
    }
}
