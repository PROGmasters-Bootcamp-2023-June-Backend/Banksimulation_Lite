package org.example;

import java.util.ArrayList;
import java.util.List;

public class BankAccountManager {

    private BankAccount account;
    private List<BankAccount> accounts = new ArrayList<>();

    public BankAccountManager() {
    }

    public BankAccount findAccount(String accountNumber) {
        for (BankAccount bankAccount : accounts) {
            if (bankAccount.getAccountNumber().equals(accountNumber)) {
                return bankAccount;
            }
        }
        return null;
    }


    public void createAccount(String ownerName, String accountNumber) {
        BankAccount bankAccount = new BankAccount(accountNumber, ownerName);
        if (findAccount(accountNumber) == null) {
            accounts.add(bankAccount);
        }
    }

    public void deposit(String accountNumber, double amount) {
        if (findAccount(accountNumber) != null) {
            findAccount(accountNumber).deposit(amount);
        }
    }

    public String withdrawFromAccount(String accountNumber, double amount) {
        if (findAccount(accountNumber) != null) {
            if (findAccount(accountNumber).getBalance() >= amount) {
                findAccount(accountNumber).withdraw(amount);
                return "Amount withdraw successfully";
            } else if (findAccount(accountNumber).getBalance() < amount) {
                return "Account's balance too low!";
            }
        }
        return "Account not found";
    }

    public double getAccountBalance(String accountNumber) {
        if (findAccount(accountNumber) != null) {
            return findAccount(accountNumber).getBalance();
        } else {
            return -1;
        }
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

}
