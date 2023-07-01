package org.example;

import java.util.ArrayList;
import java.util.List;

public class BankAccountManager {
    private List<BankAccount> accounts;

    public BankAccountManager() {
        this.accounts = new ArrayList<>();
    }

    public BankAccount findAccount(String accountNumber) {
        BankAccount bankAccount = null;

        if (accounts.size() > 0) {
            for (BankAccount account : accounts) {
                if (account.getAccountNumber().equals(accountNumber)) {
                    bankAccount = account;
                    break;
                }
            }
        }

        return bankAccount;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public void createAccount(String ownerName, String accountNumber) {
        BankAccount bankAccount = findAccount(accountNumber);

        if (bankAccount != null) {
            System.out.println("Ez a számlaszám már foglalt! Kérem, válasszon másik számlaszámot!");
        } else {
            BankAccount newBankAccount = new BankAccount(accountNumber, ownerName);
            this.accounts.add(newBankAccount);
        }
    }

    public void deposit(String accountNumber, double amount) {
        BankAccount bankAccount = findAccount(accountNumber);

        if (bankAccount == null) {
            System.out.println("Nincs ilyen számla! Kérem, ellenőrizze a számlaszámot!");
        } else {
            bankAccount.deposit(amount);
        }
    }

    public String withdrawFromAccount(String accountNumber, double amount) {
        BankAccount bankAccount = findAccount(accountNumber);

        if (bankAccount == null) {
            System.out.println("Account not found");
            return "Account not found";
        }

        if (bankAccount.getBalance() < amount) {
            return "Account's balance too low!";
        }

        bankAccount.withdraw(amount);
        return "Amount withdraw successfully";
    }

    public double getAccountBalance(String accountNumber) {
        BankAccount bankAccount = findAccount(accountNumber);

        if (bankAccount == null) {
            return -1;
        }

        return bankAccount.getBalance();
    }
}
