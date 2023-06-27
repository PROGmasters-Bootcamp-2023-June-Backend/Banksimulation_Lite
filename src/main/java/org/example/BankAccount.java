package org.example;

public class BankAccount {
    private String accountNumber;
    private String ownerName;
    private double balance = 0;

    public BankAccount(String accountNumber, String ownerName) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
    }

    public double deposit(double amount) {

        balance += amount;

        return balance;
    }

    public double withdraw(double amount) {

        if (balance == 0) {
            System.out.println("Account's balance too low!");
        } else {
            balance -= amount;
        }


        return balance;

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

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
