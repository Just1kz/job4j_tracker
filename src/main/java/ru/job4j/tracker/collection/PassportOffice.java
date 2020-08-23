package ru.job4j.tracker.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PassportOffice {
    private Map<String, Citizen> citizens = new HashMap<>();

    public boolean add(Citizen citizen) {
        boolean rsl = false;
        if (!citizens.containsKey(citizen.getPassport())) {
            rsl = true;
            citizens.put(citizen.getPassport(), citizen);
        }
        return rsl;
    }


    public Citizen get(String passport) {
        Citizen rsl = null;
        for (String key : citizens.keySet()) {
            if (key.equals(citizens.get(passport))) {
                rsl = citizens.get(passport);
                break;
            }
        }
        return rsl;
    }
}
