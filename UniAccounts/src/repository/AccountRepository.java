package repository;

import model.StudentAccount;
import java.util.HashMap;
import java.util.Map;

public class AccountRepository {

    private Map<String, StudentAccount> accounts = new HashMap<>();

    public void addAccount(StudentAccount account) {

        if (accounts.containsKey(account.getId())) {
            throw new IllegalArgumentException("Account already exists");
        }

        accounts.put(account.getId(), account);
    }

    public StudentAccount getAccount(String id) {
        return accounts.get(id);
    }
}
