package ru.job4j.tracker.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream<T> {
    private List<T> data;

    public static <T> EasyStream<T> of(List<T> source) {
        return new Builder<T>()
                .source(source)
                .build();
    }

    public EasyStream<T> map(Function<T, T> fun) {
        return new Builder<T>()
                .source(data)
                .map(fun)
                .build();
    }

    public EasyStream<T> filter(Predicate<T> fun) {
        return new Builder<T>()
                .source(data)
                .filter(fun)
                .build();
    }

    public List<T> collect() {
        return data;
    }

    static class Builder<T> {
        private List<T> source;

        Builder<T> source(List<T> list) {
            this.source = list;
            return this;
        }

        Builder<T> map(Function<T, T> fun) {
            List<T> rsl = new ArrayList<>();
            for (T t : source) {
                rsl.add(fun.apply(t));
            }
            this.source = rsl;
            return this;
        }

        Builder<T> filter(Predicate<T> filter) {
            List<T> rsl = new ArrayList<>();
            for (T t : source) {
                if (filter.test(t)) {
                    rsl.add(t);
                }
            }
            this.source = rsl;
            return this;
        }

        EasyStream<T> build() {
            EasyStream<T> stream = new EasyStream<T>();
            stream.data = source;
            return stream;
        }
    }
}
