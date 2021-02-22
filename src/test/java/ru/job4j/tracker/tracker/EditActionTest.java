package ru.job4j.tracker.tracker;

import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class EditActionTest {

    @Test
    public void execute() {
        Output out = new StubOutput();
        Store tracker = new SqlTracker();
        tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        EditAction rep = new EditAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replacedName);

        rep.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("replaces completed" + ln));
        assertThat(tracker.findAll().get(13).getName(), is(replacedName));
    }
}