package org.example;

import java.util.ArrayList;
import java.util.List;

public class BankAccountManager {


    private String findAccountNumber;

    private List<Object> accounts;

    public BankAccountManager() {
        this.accounts = new ArrayList<>();
    }

    public String findAccount(String findAccountNumber) {
        BankAccount bankAccount = new BankAccount();
        if ( findAccountNumber.equals(bankAccount.getAccountNumber()))  {
            bankAccount.getAccountNumber();
        }
        return null;
    }

    public void createAccount(String ownerName, String accountNumber) {
        BankAccount bankAccount = new BankAccount();
        for (BankAccount bankAccount : this.accounts) {
            if (!accounts.contains(bankAccount)) {
                accounts.add(bankAccount);
            }
        }
    }





    public void deposit(String accountNumber, double amount) {
        BankAccount bankAccount = new BankAccount();
        if (accountNumber.equals(bankAccount.getAccountNumber()))  {
            bankAccount.deposit(amount);
        }

    }
    public void withdrawFromAccount(String accountNumber,double amount) {
        BankAccount bankAccount = new BankAccount();
        if (accountNumber.equals(bankAccount.getAccountNumber())) {
            bankAccount.withdraw(amount);
            System.out.println("Amount withdraw successfully");
        }else if ( bankAccount.getBalance() < amount ) {
            System.out.println("Account's balance too low!");
        }else {
            System.out.println("Account not found");
        }

    }
    public void getAccountBalance(String accountNumber) {
        BankAccount bankAccount = new BankAccount();
        if (bankAccount.getAccountNumber().equals(accountNumber)) {
            bankAccount.getBalance();
        }

    }
    public List<Object> getAccounts() {
        return accounts;
    }

}
