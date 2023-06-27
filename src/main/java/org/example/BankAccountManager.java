package org.example;

import java.util.ArrayList;
import java.util.List;

public class BankAccountManager {
    private ArrayList<BankAccount> bankAccounts = new ArrayList<>();

    public BankAccountManager() {
        this.bankAccounts = bankAccounts;
    }

    public BankAccount findAccount(String accountNumber) {
        BankAccount bankAccount;
        for (int i = 0; i < bankAccounts.size(); i++) {
            if(bankAccounts.get(i).getAccountNumber().equals(accountNumber)) {
                bankAccount = bankAccounts.get(i);
                return bankAccount;
            }
        }
        return null;
    }

    public void createAccount(String ownerName, String accountNumber) {
        if(bankAccounts.contains(findAccount(accountNumber))) {
            System.out.println("Warning message!!!");
        } else {
            BankAccount bankAccount = new BankAccount(ownerName, accountNumber);
            bankAccounts.add(bankAccount);
        }
    }

    public void deposit(String accountNumber, double amount) {
        BankAccount bankAccount = findAccount(accountNumber);
        try{
            if(!bankAccount.getAccountNumber().equals(null)) {
                bankAccount.setBalance(amount + bankAccount.getBalance());
            }
        } catch (NullPointerException nullPointerException) {
            System.out.println(nullPointerException.getMessage());
        }

    }

    public String withdrawFromAccount(String accountNumber, double amount) {
        BankAccount bankAccount = findAccount(accountNumber);
        if(bankAccount != (null)) {
            if (bankAccount.getBalance() < amount) {
                return "Account's balance too low!";
            }
            if (bankAccount.getBalance() >= amount) {
                bankAccount.setBalance(bankAccount.getBalance() - amount);
                return "Amount withdraw successfully";
            }
        }
        return "Account not found";
    }

    public double getAccountBalance(String accountNumber) {
        BankAccount bankAccount = findAccount(accountNumber);
        if(bankAccount == (null)) {
            return -1;
        }
        return bankAccount.getBalance();
    }

    public List getAccounts() {
        return bankAccounts;
    }
}
