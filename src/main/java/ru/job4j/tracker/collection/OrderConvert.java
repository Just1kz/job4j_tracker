package ru.job4j.tracker.collection;

import java.util.HashMap;
import java.util.List;

public class OrderConvert {
    public static HashMap<String, Order> process(List<Order> orders) {
        HashMap<String, Order> map = new HashMap<>();
        for (Order converter : orders) {
            map.put(converter.getNumber(), converter);
        }
        return map;
    }
}
