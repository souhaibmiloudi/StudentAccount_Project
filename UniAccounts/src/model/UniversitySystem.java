package model;

import repository.AccountRepository;
import logging.AuditLog;
import java.util.List;

public class UniversitySystem {

    private static UniversitySystem instance;

    private AccountRepository repository;
    private AuditLog auditLog;

    private UniversitySystem() {
        repository = new AccountRepository();
        auditLog = new AuditLog();
    }

    public static UniversitySystem getInstance() {

        if (instance == null) {
            instance = new UniversitySystem();
        }

        return instance;
    }

    public void addAccount(StudentAccount account) {
        repository.addAccount(account);
        auditLog.log("Account " + account.getId() + " created");
    }

    public StudentAccount getAccount(String id) {
        return repository.getAccount(id);
    }

    public List<String> getAuditLog() {
        return auditLog.getAuditLog();
    }
}
