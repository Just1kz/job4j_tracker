package ru.job4j.tracker.rslTaskOfLvl1;

public class Merge {
    public static int[] merge(int[] left, int[] right) {
        int tmp = 0;
        int min = 0;
        int middle = 0;
        int max = 0;
        int[] rsl = new int[left.length + right.length];
        for(int i = 0; i < rsl.length; i++) {
            if (rsl[rsl.length - 1] != 0) {
                break;
            }
            if (i < left.length && i < right.length) {
                if (rsl[i] == 0) {
                    rsl[i] = Math.min(left[i], right[i]);
                    rsl[i + 1] = Math.max(left[i], right[i]);
                } else {
                    min = rsl[i] < left[i] && rsl[i] < right[i] ? rsl[i] :
                            left[i] < rsl[i] && left[i] < right[i] ? left[i] : right[i];
                    middle = (rsl[i] > left[i] && rsl[i] < right[i]) ||
                            (rsl[i] < left[i] && rsl[i] > right[i]) ? rsl[i] :
                            (left[i] > rsl[i] && left[i] < right[i]) ||
                                    (left[i] < rsl[i] && left[i] > right[i]) ?
                                    left[i] : right[i];
                    max = rsl[i] > left[i] && rsl[i] > right[i] ? rsl[i] :
                            left[i] > rsl[i] && left[i] > right[i] ? left[i] : right[i];
                    rsl[i] = min;
                    rsl[i+1] = middle;
                    rsl[i+2] = max;
                }
            } else if (i < left.length) {
                rsl[i] = left[i];
            } else  {
                tmp = i - left.length;
                rsl[i] = right[tmp];
            }
        }
        return rsl;
    }
}
