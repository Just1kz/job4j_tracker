package ru.job4j.tracker.tracker;

import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FindNameActionTest {

    @Test
    public void execute() {
        Output out = new StubOutput();
        Store tracker = new SqlTracker();
        tracker.add(new Item("FindNameAction"));

        FindNameAction rep = new FindNameAction(out);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn("FindNameAction");

        rep.execute(input, tracker);

        Item rsl = new Item("36", "FindNameAction");

        String ln = System.lineSeparator();
        assertThat(out.toString(), is(rsl.toString() + ln));
    }
}