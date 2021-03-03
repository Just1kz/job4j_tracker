package ru.job4j.tracker.tracker;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.tracker.tracker.Item;
import ru.job4j.tracker.tracker.MemTracker;

import static org.hamcrest.core.IsNull.nullValue;

public class TrackerTest {


    @Test
    public void whenReplace() {
        MemTracker tracker = new MemTracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        Integer id = bug.getId();
        Item bugWithDesc = new Item("Bug with description");
        tracker.replace(0, bugWithDesc);
        assertThat(tracker.findById(0).getName(), is("Bug with description"));
    }


    @Test
    public void whenDelete() {
        MemTracker tracker = new MemTracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        Integer id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }
}