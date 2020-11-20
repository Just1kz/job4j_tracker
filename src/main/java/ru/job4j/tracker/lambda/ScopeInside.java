package ru.job4j.tracker.lambda;

import java.util.function.Supplier;

public class ScopeInside {
    public static void main(String[] args) {
        int[] number = {1, 2, 3};
        int total = 0;
        int totalRsl = 0;
        for (int i = 0; i < number.length; i++) {
            totalRsl += number[i];
            int finalTotalRsl = totalRsl;
            total = add(
                    () -> finalTotalRsl
            );
        }
        System.out.println(total);
    }

    private static Integer add(Supplier<Integer> calc) {
        return calc.get();
    }
}
