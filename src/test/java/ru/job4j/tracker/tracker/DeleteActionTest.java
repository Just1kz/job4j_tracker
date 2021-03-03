package ru.job4j.tracker.tracker;

import org.junit.Ignore;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class DeleteActionTest {

    @Ignore
    @Test
    public void execute() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("New item"));

        DeleteAction rep = new DeleteAction(out);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn("1");

        rep.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("delete completed" + ln));
    }
}