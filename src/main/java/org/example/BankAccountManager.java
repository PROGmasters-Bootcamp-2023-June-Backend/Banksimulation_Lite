package org.example;

import java.util.ArrayList;
import java.util.List;


public class BankAccountManager {

    private List<BankAccount> accounts;

    public BankAccountManager() {
        this.accounts = new ArrayList<>();
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public BankAccount findAccount (String accountNumber) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNumber().equals(accountNumber)) {
                return accounts.get(i);
            }
        }
        return null;
    }

    public void createAccount(String ownerName, String accountNumber) {
        if (accounts.contains(findAccount(accountNumber))) {
            System.out.println("Warning, this account is already exist!");
        } else {
            accounts.add(new BankAccount(accountNumber, ownerName));
        }
    }

    public void deposit(String accountNumber, double amount) {
        if (findAccount(accountNumber) != null) {
            findAccount(accountNumber).deposit(amount);
        }
    }

    public double getAccountBalance(String accountNumber) {
        if (findAccount(accountNumber) == null) {
            return -1;
        } else {
            return findAccount(accountNumber).getBalance();
        }
    }

    public String withdrawFromAccount(String accountNumber, double amount) {
        BankAccount bankAccount = findAccount(accountNumber);
        String withDrawResult = "Account not found";

        if (bankAccount != null && bankAccount.getBalance() >= amount) {
           bankAccount.withdraw(amount);
            withDrawResult = "Amount withdraw successfully";
        } else if (bankAccount != null && bankAccount.getBalance() < amount) {
            bankAccount.withdraw(amount);
            withDrawResult = "Account's balance too low!";
        }
        return withDrawResult;
    }




}


