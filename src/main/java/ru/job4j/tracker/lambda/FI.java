package ru.job4j.tracker.lambda;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

public class FI {
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("image 1", 20),
                new Attachment("image 3", 120),
                new Attachment("image 2", 23)
        };
        Comparator<Attachment> comparator = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment left, Attachment right) {
                return left.getSize() - right.getSize();
            }
        };
        Arrays.sort(atts, comparator);

        Student [] rsl = {new Student("Petr", 6.5),
                                        new Student("Anton", 5.5),
                                        new Student("Stas", 7.5)
        };
        Comparator<Student> comparator2 = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        Arrays.sort(rsl, comparator2);

        Function<Student, InputStream> func = new Function<Student, InputStream>() {
            @Override
            public InputStream apply(Student student) {
                return null;
            }
        };
    }
}
