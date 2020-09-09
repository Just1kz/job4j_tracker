package ru.job4j.tracker.collection;

import org.junit.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.SortByNameAsc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class JobAscByNameTest {

    @Test
    public void compare() {
        List<Job> itemStart = Arrays.asList(
                new Job( "Bob", 1),
                new Job("Jhon", 3),
                new Job("Anton", 2)
        );
        List<Job> itemEnd = Arrays.asList(
                new Job("Anton", 2),
                new Job("Bob", 1),
                new Job("Jhon", 3)
        );
        Collections.sort(itemStart, new JobAscByName());
        assertThat(String.valueOf(itemStart), is(String.valueOf(itemEnd)));
    }
}