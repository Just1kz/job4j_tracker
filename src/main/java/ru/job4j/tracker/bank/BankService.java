package ru.job4j.tracker.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User rsl = null;
        rsl = findByPassport(passport);
        if (rsl != null && !users.get(rsl).contains(account)) {
            users.get(rsl).add(account);
        }
    }

    public User findByPassport(String passport) {
        User rsl = null;
        for (User find : users.keySet()) {
            if (find.getPassport().equals(passport)) {
                rsl = find;
                break;
            }
        }
        return rsl;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = null;
        user = findByPassport(passport);
        Account rsl = null;
        if (user != null) {
            for (Account accounts : users.get(user)) {
                if (accounts.getRequisite().equals(requisite)) {
                    rsl = accounts;
                    break;
                }
            }
        }
        return rsl;
    }

    public boolean transferMoney(
            String srcPassport, String srcRequisite,
            String destPassport, String dеstRequisite, double amount) {
        boolean rsl = false;
        Account accountSrc = findByRequisite(srcPassport, srcRequisite);
        Account accountDest = findByRequisite(destPassport,dеstRequisite);
        if (accountSrc != null && accountDest != null && accountSrc.getBalance() > amount) {
            accountSrc.setBalance(accountSrc.getBalance() - amount);
            accountDest.setBalance(accountDest.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
