package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BankAccountManager {

    private List<BankAccount> bankAccounts;

    public BankAccountManager() {
        this.bankAccounts = new ArrayList<>();

    }

    public BankAccount findAccount(String accountNumber) {

        for (BankAccount bankAccount : bankAccounts) {
            if (bankAccount.getAccountNumber().equals(accountNumber)) {
                return bankAccount;
            }
        }
        return null;
    }


    public void createAccount(String ownerName, String accountNumber) {
        if (findAccount(accountNumber) != null) {
            return;
        }

        BankAccount bankAccount = new BankAccount(accountNumber, ownerName);
        bankAccounts.add(bankAccount);
    }

    public String deposit(String accountNumber, double amount) {
        BankAccount bankAccount = findAccount(accountNumber);
        if (bankAccount == null) {
            return "Account not found";
        }
        bankAccount.deposit(amount);
        return "Amount deposit successfully";
    }

    public String withdrawFromAccount(String accountNumber, double amount) {
        BankAccount bankAccount = findAccount(accountNumber);
        if (bankAccount == null) {

            return "Account not found";
        }
        return bankAccount.withdraw(amount);

    }

    public double getAccountBalance(String accountNumber) {
        BankAccount bankAccount = findAccount(accountNumber);
        if (bankAccount == null) {
            return -1;
        }
        return bankAccount.getBalance();
    }

    public List<BankAccount> getAccounts() {
        return bankAccounts;
    }
}


