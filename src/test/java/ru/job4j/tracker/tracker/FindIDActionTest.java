package ru.job4j.tracker.tracker;

import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FindIDActionTest {

    @Test
    public void execute() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("FindIDAction"));

        FindIDAction rep = new FindIDAction(out);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn("1");

        rep.execute(input, tracker);

        Item rsl = new Item("1", "FindIDAction");
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(rsl.toString() + ln));
    }
}