package org.example;


public class BankAccount {
    private String accountNumber;
    private String ownerName;
    private double balance;

    public BankAccount(String ownerName, String accountNumber) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = 0.0;
    }


    public double deposit(double amount) {
        return this.balance + amount;
    }

    public double withdraw(double amount) {
        if(this.balance < amount) {
            System.out.println("Account's balance too low!");
            return this.balance;
        } else {
            System.out.println("Amount withdraw successfully");
            return this.balance - amount;
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
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
