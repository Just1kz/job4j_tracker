package ru.job4j.tracker.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        User rsl = findByPassport(passport);
        if (rsl != null && !users.get(rsl).contains(account)) {
            users.get(rsl).add(account);
        }
    }

    public User findByPassport(String passport) {
        return (User) users.keySet().stream()
                .filter(x -> x.getPassport().equals(passport))
                .findFirst()
                .orElse(new User("123"));
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        Account rsl = null;
        if (user != null) {
            rsl = users.get(user).stream()
                    .filter(x -> x.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(new Account("aasd", 123.00));
        }
        return rsl;
    }

    public boolean transferMoney(
            String srcPassport, String srcRequisite,
            String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account accountSrc = findByRequisite(srcPassport, srcRequisite);
        Account accountDest = findByRequisite(destPassport, destRequisite);
        if (accountSrc != null && accountDest != null && accountSrc.getBalance() >= amount) {
            accountSrc.setBalance(accountSrc.getBalance() - amount);
            accountDest.setBalance(accountDest.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
