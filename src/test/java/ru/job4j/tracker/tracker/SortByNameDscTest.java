package ru.job4j.tracker.tracker;

import org.junit.Test;
import ru.job4j.tracker.tracker.Item;
import ru.job4j.tracker.tracker.SortByNameDsc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SortByNameDscTest {

    @Test
    public void compare() {
        List<Item> itemStart = Arrays.asList(
                new Item(1, "Bob"),
                new Item(3, "Jhon"),
                new Item(2, "Anton")
        );
        List<Item> itemEnd = Arrays.asList(
                new Item(3, "Jhon"),
                new Item(1, "Bob"),
                new Item(2, "Anton")
        );
        Collections.sort(itemStart, new SortByNameDsc());
        assertThat(String.valueOf(itemStart), is(String.valueOf(itemEnd)));
    }
}