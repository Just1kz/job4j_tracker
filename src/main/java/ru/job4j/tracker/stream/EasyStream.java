package ru.job4j.tracker.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream<T> {
    private List<T> data;
    private Predicate<T> filter;
    private Function<T, T> fun;

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
        List<T> list = new ArrayList<>();
        if (filter != null) {
            for (T rsl : data) {
                if (filter.test(rsl)) {
                    list.add(rsl);
                }
            }
        }
        if (fun != null) {
            for (T rsl : data) {
                list.add(fun.apply(rsl));
            }
        }
        if (filter != null && fun != null) {
            list.addAll(data);
        }
        return list;
    }

    static class Builder<T> {
        private List<T> source;
        private Predicate<T> filter;
        private Function<T, T> fun;

        Builder<T> source(List<T> list) {
            this.source = list;
            return this;
        }

        Builder<T> map(Function<T, T> fun) {
            this.fun = fun;
            return this;
        }

        Builder<T> filter(Predicate<T> filter) {
            this.filter = filter;
            return this;
        }

        EasyStream<T> build() {
            EasyStream<T> stream = new EasyStream<T>();
            stream.data = source;
            stream.filter = filter;
            stream.fun = fun;
            return stream;
        }
    }
}
