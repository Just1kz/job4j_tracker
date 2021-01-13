package ru.job4j.tracker.tracker;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.tracker.tracker.*;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    private static final String LN = System.lineSeparator();

    @Ignore
    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Store tracker = new SqlTracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Replaced item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new EditAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
        assertThat(out.toString(), is("Menu." + LN
                + "0. === Edit Item ====" + LN
                + "1. === Exit Menu ===" + LN
                + "replaces completed" + LN
                + "Menu." + LN
                + "0. === Edit Item ====" + LN
                + "1. === Exit Menu ===" + LN));
    }

    @Ignore
    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Store tracker = new SqlTracker();
        Item item = tracker.add(new Item("Deleted item"));

        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Store tracker = new SqlTracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + LN
                + "0. === Exit Menu ===" + LN));
    }

    @Test
    public void whenFindAllAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        Store tracker = new SqlTracker();
        UserAction[] actions = {
                new ShowAllAction(),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + LN
                + "0. === Show all items ===" + LN
                + "1. === Exit Menu ===" + LN
                + "Menu." + LN
                + "0. === Show all items ===" + LN
                + "1. === Exit Menu ===" + LN));
    }

    @Ignore
    @Test
    public void whenFindByIdAction() {
        Output out = new StubOutput();
        Store tracker = new SqlTracker();
        Item item = tracker.add(new Item("Find ID"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new FindIDAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + LN
                + "0. === Find by Id ====" + LN
                + "1. === Exit Menu ===" + LN
                + item + LN
                + "Menu." + LN
                + "0. === Find by Id ====" + LN
                + "1. === Exit Menu ===" + LN));
    }

    @Ignore
    @Test
    public void whenFindByNameAction() {
        Output out = new StubOutput();
        Store tracker = new SqlTracker();
        Item item = tracker.add(new Item("Find Name"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getName()), "1"}
        );
        UserAction[] actions = {
                new FindNameAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + LN
                + "0. === Find by Name ====" + LN
                + "1. === Exit Menu ===" + LN
                + item + LN
                + "Menu." + LN
                + "0. === Find by Name ====" + LN
                + "1. === Exit Menu ===" + LN));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"9", "0"}
        );
        Store tracker = new SqlTracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format("Menu.%n"
                                + "0. === Exit Menu ===%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0. === Exit Menu ===%n"
                )
        ));
    }

}