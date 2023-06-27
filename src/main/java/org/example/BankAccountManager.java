package org.example;

import java.util.ArrayList;
import java.util.List;

public class BankAccountManager {
    private List<BankAccount> accounts = new ArrayList<>();

    public BankAccountManager() {

    }

    public BankAccount findAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public void createAccount(String ownerName, String accountNumber) {
        if (findAccount(accountNumber) != null) {
            System.out.println("Account number already taken");
        } else {
            BankAccount bankAccount = new BankAccount(accountNumber, ownerName);
            accounts.add(bankAccount);
        }

    }

    public void deposit(String accountNumber, double amount) {
        BankAccount bankAccountFound = findAccount(accountNumber);
        if (findAccount(accountNumber) != null) {
            bankAccountFound.deposit(amount);
        }

    }

    public String withdrawFromAccount(String accountNumber, double amount) {
        BankAccount bankAccountFound = findAccount(accountNumber);
        if (findAccount(accountNumber) != null&&findAccount(accountNumber).getBalance()-amount>0) {
            bankAccountFound.withdraw(amount);
            return "Amount withdraw successfully";
        } else if (findAccount(accountNumber) != null &&findAccount(accountNumber).getBalance()-amount<0 ) {
        return "Account's balance too low!";
        } else {
            return "Account not found";
        }
    }
    public double getAccountBalance(String accountNumber){
        BankAccount bankAccountFound = findAccount(accountNumber);
        if (findAccount(accountNumber) != null) {
            return bankAccountFound.getBalance();
        }
        else {
            return -1;
        }
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<BankAccount> accounts) {
        this.accounts = accounts;
    }
}


