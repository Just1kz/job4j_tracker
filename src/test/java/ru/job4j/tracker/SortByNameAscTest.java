package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SortByNameAscTest {

    @Test
    public void compare() {
        List<Item> itemStart = Arrays.asList(
                new Item(1, "Bob"),
                new Item(3, "Jhon"),
                new Item(2, "Anton")
        );
        List<Item> itemEnd = Arrays.asList(
                new Item(2, "Anton"),
                new Item(1, "Bob"),
                new Item(3, "Jhon")
        );
        Collections.sort(itemStart, new SortByNameAsc());
        assertThat(String.valueOf(itemStart), is(String.valueOf(itemEnd)));
    }
}