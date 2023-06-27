package org.example;

import java.util.ArrayList;
import java.util.List;

public class BankAccountManager {

    private List<BankAccount> accounts;

    public BankAccountManager(){
        accounts = new ArrayList<>();
    }

    public BankAccountManager(List<BankAccount> accounts) {
        this.accounts = accounts;
    }

    public BankAccount findAccount (String accountNumber) {
        for (BankAccount account: accounts) {
            if (account.getAccountNumber().equals(accountNumber))
                return account;
        }
        return null;
    }

    public void createAccount(String ownerName, String accountNumber) {
        BankAccount existingAccount = findAccount(accountNumber);
        if (existingAccount != null){
            System.out.println("An account with the provided account number already exists!");
        }
        BankAccount newAccount = new BankAccount(ownerName, accountNumber);
        accounts.add(newAccount);
    }

    public void deposit(String accountNumber, double amount) {
    }

    public void withdrawFromAccount(String accountNumber, double amount) {
    }

    public double getAccountBalance(String accountNumber) {
    }
}
