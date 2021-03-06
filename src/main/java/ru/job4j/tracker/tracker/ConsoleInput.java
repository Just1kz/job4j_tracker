package ru.job4j.tracker.tracker;

import java.io.InputStream;
import java.util.Scanner;

public class ConsoleInput implements  Input {
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleInput(InputStream in) {
    }

    public ConsoleInput() {
    }

    @Override
    public String askStr(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    @Override
    public int askInt(String question) {
        return Integer.valueOf(askStr(question));
    }
}
