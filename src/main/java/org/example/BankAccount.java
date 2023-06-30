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

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit (double amount){
        this.balance += amount;
    }
    public void withdraw (double amount){
        if (balance - amount > 0) {
            this.balance -= amount;
        }else{
            System.out.println("Account's balance too low.");
        }
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
