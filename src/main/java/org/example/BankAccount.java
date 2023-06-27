package org.example;

public class BankAccount {

    private String accountNumber;
    private String ownerName;
    private  double balance;

    public BankAccount(String accountNumber, String ownerName) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance=0;
    }

    public void deposit(double deposit){
        double newBalance = getBalance()+ deposit;
        setBalance(newBalance);
    }

    public void withdraw(double withdraw){
        double newBalance = getBalance()- withdraw;
        if(newBalance>0) {
            setBalance(newBalance);
        }
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

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount: " +
                "Account Number: " + accountNumber +
                ", Owner Name:" + ownerName +
                ", Balance: " + balance ;
    }
}
