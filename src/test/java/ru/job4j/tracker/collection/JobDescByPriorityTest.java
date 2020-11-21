package ru.job4j.tracker.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class JobDescByPriorityTest {

    @Test
    public void compare() {
        List<Job> itemStart = List.of(
                new Job("Bob", 1),
                new Job("Jhon", 3),
                new Job("Anton", 2)
        );
        List<Job> itemEnd = List.of(
                new Job("Jhon", 3),
                new Job("Anton", 2),
                new Job("Bob", 1)
        );
        Collections.sort(itemStart, new JobDescByPriority());
        assertThat(String.valueOf(itemStart), is(String.valueOf(itemEnd)));
    }
}