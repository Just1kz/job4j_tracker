package ru.job4j.tracker.stream;

import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(x -> Stream.of(Value.values())
                            .map(y -> x + " " + y))
                    .forEach(System.out::println);
    }
}

