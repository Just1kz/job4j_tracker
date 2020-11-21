package ru.job4j.tracker.bank;

import java.util.*;

public class BankService {
    private final Map<Optional<User>, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(Optional.of(user), new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        Optional<User> rsl = findByPassport(passport);
        if (rsl.isPresent() && !users.get(rsl).contains(account)) {
            users.get(rsl).add(account);
        }
    }

    public Optional<User> findByPassport(String passport) {
        Optional<User> rsl = Optional.empty();
        for (Optional<User> user : users.keySet()) {
            if (user.isPresent()) {
                if (user.get().getPassport().equals(passport)) {
                    rsl = user;
                    break;
                }
            }
        }
        return rsl;
    }

    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        Optional<Account> rsl = Optional.empty();
        if (user.isPresent()) {
            rsl = Optional.of(users.get(user).stream()
                    .filter(x -> x.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(new Account("aasd", 123.00)));
        }
        return rsl;
    }

    public boolean transferMoney(
            String srcPassport, String srcRequisite,
            String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> accountSrc = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> accountDest = findByRequisite(destPassport, destRequisite);
        if (accountSrc.isPresent() && accountDest.isPresent() && accountSrc.get().getBalance() >= amount) {
            accountSrc.get().setBalance(accountSrc.get().getBalance() - amount);
            accountDest.get().setBalance(accountDest.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
