package org.example;

import java.util.PrimitiveIterator;

public class BankAccount {

    private String accountNumber;
    private String ownerName;
    private double balance;

    private static final double STARTER_BALANCE = 0.0;

    public BankAccount(String accountNumber, String ownerName) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = STARTER_BALANCE;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds");
        }
    }

    @Override
    public String toString() {
        return "BankAccount: " +
                "accountNumber: " + accountNumber + '\'' +
                ", ownerName: " + ownerName + '\'' +
                ", balance: " + balance;
    }
}
