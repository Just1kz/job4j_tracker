package ru.job4j.tracker.stream;

import org.junit.Test;

import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MatrixTest {

    @Test
    public void reMatrixToList() {
        Integer[][] ar = {{1, 2, 3}, {4, 5, 6}};
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        assertThat(Matrix.reMatrixToList(ar), is(list));
    }
}