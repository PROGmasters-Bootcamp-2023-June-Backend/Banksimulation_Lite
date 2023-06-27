package org.example;

import java.util.ArrayList;
import java.util.List;

public class BankAccountManager {

    private List<BankAccount> accounts;

    public BankAccountManager() {
        this.accounts = new ArrayList<>();
    }

    public void createAccount(String ownerName, String accountNumber) {
        BankAccount bankAccountToFind = findAccount(accountNumber);
        if (bankAccountToFind == null) {
            BankAccount account = new BankAccount(accountNumber, ownerName);
            accounts.add(account);
            System.out.println("Account created. Account Number: " + accountNumber);
        }
    }

    public void deposit(String accountNumber, double amount) {
        BankAccount bankAccountToFind = findAccount(accountNumber);
        if (bankAccountToFind != null) {
            bankAccountToFind.deposit(amount);
            System.out.println("Amount deposited successfully");
        } else {
            System.out.println("Account not found");
        }
    }

    public String withdrawFromAccount(String accountNumber, double amount) {
        BankAccount account = findAccount(accountNumber);
        String resultMessage = "Account not found";
        if (account != null) {
            boolean isWithdrawingPossible = account.getBalance() > 0 && account.getBalance() > amount;
            if (isWithdrawingPossible) {
                account.withdraw(amount);
                resultMessage = "Amount withdraw successfully";
            } else {
                resultMessage = "Account's balance too low!";
            }
        }
        return resultMessage;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public double getAccountBalance(String accountNumber) {
        BankAccount account = findAccount(accountNumber);
        if (account != null) {
            return account.getBalance();
        } else {
            return -1;
        }
    }

    public BankAccount findAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}
