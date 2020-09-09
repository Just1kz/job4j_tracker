package ru.job4j.tracker.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JobSorter {
    public static void main(String[] args) {
//        List<Job> jobs = Arrays.asList(
//                new Job("Iix bugs", 2),
//                new Job("Fmpl task", 4),
//                new Job("Reboot server", 1)
//        );
//        System.out.println(jobs);
//        Collections.sort(jobs);
//        System.out.println(jobs);
//        System.out.println();
//        Collections.sort(jobs, Collections.reverseOrder());
//        System.out.println(jobs);
//        System.out.println();
//        Collections.sort(jobs, new SortByNameAsc());
//        System.out.println(jobs);
//        Collections.sort(jobs, new SortByNameDsc());
//        System.out.println(jobs);
            List<Job> jobs = Arrays.asList(
                    new Job("Fix bug", 1),
                    new Job("Fix bug", 4),
                    new Job("Fix bug", 2),
                    new Job("X task", 0)
            );
            Collections.sort(jobs, new JobDescByName().thenComparing(new JobDescByPriority()));
            System.out.println(jobs);
            System.out.println();
            Comparator<Job> comb = new JobDescByName()
                .thenComparing(new JobDescByPriority())
                .thenComparing(new JobDescByNameLn());
            Collections.sort(jobs, comb);
            System.out.println(jobs);
        }
    }
