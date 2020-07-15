package ru.job4j.tracker;

//import org.junit.Test;
//
//import static org.hamcrest.CoreMatchers.nullValue;
//import static org.hamcrest.core.Is.is;
//import static org.junit.Assert.*;
//import static org.hamcrest.Matchers.is;
//import static org.junit.Assert.assertThat;
//import static sun.jvm.hotspot.runtime.VMOps.Exit;

//public class StartUITest {
//
//    @Test
//    public void whenCreateItem() {
//        Input in = new StubInput(
//                new String[] {"0", "Item name", "1"}
//        );
//        Tracker tracker = new Tracker();
//        UserAction[] actions = {
//                new CreateAction(),
//                new Exit()
//        };
//        new StartUI().init(in, tracker, actions);
//        assertThat(tracker.findAll()[0].getName(), is("Item name"));
//    }
//
//    @Test
//    public void whenReplaceItem() {
//        Tracker tracker = new Tracker();
//        /* Добавим в tracker новую заявку */
//        Item item = tracker.add(new Item("Replaced item"));
//        /* Входные данные должны содержать ID добавленной заявки item.getId() */
//        String replacedName = "New item name";
//        Input in = new StubInput(
//                new String[] {"0" /* входные параметры для ReplaceAction */, "1"}
//        );
//        UserAction[] actions = {
//                new ReplaceAction(),
//                new Exit()
//        };
//        new StartUI().init(in, tracker, actions);
//        assertThat(tracker.findById(item.getId()), is(replacedName));
//    }
//
//    @Test
//    public void whenDeleteItem() {
//        Tracker tracker = new Tracker();
//        /* Добавим в tracker новую заявку */
//        Item item = tracker.add(new Item("Deleted item"));
//        /* Входные данные должны содержать ID добавленной заявки item.getId() */
//        Input in = new StubInput(
//                new String[] {"0" /* входные параметры для DeleteAction */, "1"}
//        );
//        UserAction[] actions = {
//                new DeleteAction(),
//                new Exit()
//        };
//        new StartUI().init(in, tracker, actions);
//        assertThat(tracker.findById(item.getId()), is(nullValue()));
//    }
//}