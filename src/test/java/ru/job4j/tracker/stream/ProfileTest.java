package ru.job4j.tracker.stream;

import org.junit.Test;

import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfileTest {

    @Test
    public void collect() {
        Profile pr1 = new Profile(1, "Anton",
                new Address("Novosibirsk", "Blue", 15, 44));
        Profile pr2 = new Profile(2, "Andrey",
                new Address("Novosibirsk", "Blue", 15, 44));
        Profile pr3 = new Profile(3, "Elena",
                new Address("Voronezh", "Black", 11, 55));
        List<Profile> input = List.of(pr1, pr2, pr3);
        List<Address> output = List.of(
                new Address("Novosibirsk", "Blue", 15, 44),
                new Address("Voronezh", "Black", 11, 55)
        );
        List<Address> list = Profile.collect(input);
        assertThat(list, is(output));
    }
}