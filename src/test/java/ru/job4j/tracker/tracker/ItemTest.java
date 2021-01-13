package ru.job4j.tracker.tracker;

import org.junit.Test;
import ru.job4j.tracker.tracker.Item;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void compareToAsc() {
        List<Item> itemStart = Arrays.asList(
                new Item("1", "Bob"),
                new Item("3", "Jhon"),
                new Item("2", "Anton")
        );
        List<Item> itemEnd = Arrays.asList(
                new Item("1", "Bob"),
                new Item("2", "Anton"),
                new Item("3", "Jhon")
        );
        Collections.sort(itemStart);
        assertThat(String.valueOf(itemStart), is(String.valueOf(itemEnd)));
    }

    @Test
    public void compareToDsc() {
        List<Item> itemStart = Arrays.asList(
                new Item("1", "Bob"),
                new Item("3", "Jhon"),
                new Item("2", "Anton")
        );
        List<Item> itemEnd = Arrays.asList(
                new Item("3", "Jhon"),
                new Item("2", "Anton"),
                new Item("1", "Bob")
        );
        Collections.sort(itemStart, Collections.reverseOrder());
        assertThat(String.valueOf(itemStart), is(String.valueOf(itemEnd)));
    }
}