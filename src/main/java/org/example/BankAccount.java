package org.example;

public class BankAccount {

    private String accountNumber;
    private String ownerName;
    private double balance;

    public BankAccount(String accountNumber, String ownerName) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = 0;
    }

    public double deposit(double amount) {
        double newAmount = this.balance + amount;
        return newAmount;
    }

    //TODO Subtracts the given amount from the account balance if there are sufficient funds.

    public double withdraw(double amount) {
        double newAmount;
        if (this.balance > amount) {
           newAmount = this.balance - amount;
        }
        return newAmount;
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
}