package ru.job4j.tracker.rslTaskOfLvl1;

public class Merge {
    public static int[] merge(int[] left, int[] right) {
        int tmp = 0;
        int[] rsl = new int[left.length + right.length];
        for(int i = 0; i < rsl.length; i++) {
            if(i < left.length) {
                rsl[i] = left[i];
            } else {
                tmp = i - left.length;
                rsl[i] = right[tmp];
            }
        }
        for (int i = 0; i < rsl.length; i++) {
            if(i == rsl.length -1) {
                break;
            }
            if (rsl[i] > rsl[i+1]) {
                tmp = rsl[i];
                rsl[i] = rsl[i+1];
                rsl[i+1] = tmp;
            }
        }
        return rsl;
    }
}
