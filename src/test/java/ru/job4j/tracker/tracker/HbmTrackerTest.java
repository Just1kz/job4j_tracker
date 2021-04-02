package ru.job4j.tracker.tracker;

import org.junit.Test;

import java.sql.Timestamp;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class HbmTrackerTest {

    private final Item item = new Item("first", "someDesc",
            new Timestamp(System.currentTimeMillis()));
    private final Item item2 = new Item("second", "someDesc",
            new Timestamp(System.currentTimeMillis()));
    private final HbmTracker hbmTracker = new HbmTracker();

    @Test
    public void add() {
        hbmTracker.add(item);
        List<Item> list = hbmTracker.findAll();
        assertEquals(item.toString(), list.get(0).toString());
    }

    @Test
    public void replace() {
        hbmTracker.add(item);
        hbmTracker.add(item2);
        boolean rsl = hbmTracker.replace(1, item2);
        assertTrue(rsl);
        assertThat(hbmTracker.findById(1).toString(), is(item2.toString()));
    }

    @Test
    public void delete() {
        hbmTracker.add(item);
        hbmTracker.delete(1);
        List<Item> list = hbmTracker.findAll();
        assertThat(list.size(), is(0));
    }

    @Test
    public void findAll() {
        hbmTracker.add(item);
        List<Item> input = hbmTracker.findAll();
        List<Item> output = List.of(item);
        assertEquals(input.toString(), output.toString());
    }

    @Test
    public void findByName() {
        hbmTracker.add(item);
        Item rsl = hbmTracker.findByName(item.getName()).get(0);
        assertEquals(rsl.toString(), item.toString());
    }

    @Test
    public void findById() {
        hbmTracker.add(item);
        Item rsl = hbmTracker.findById(1);
        assertEquals(rsl.toString(), item.toString());
    }
}