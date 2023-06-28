package org.example;

public class BankAccount {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("11273437","Kovács Géza");
        bankAccount.deposit(12000);
        bankAccount.deposit(4000);

        System.out.println(bankAccount.getBalance());
        System.out.println(bankAccount.getAccountNumber());

        bankAccount.withdraw(17000);
        bankAccount.withdraw(11000);
        System.out.println(bankAccount.getBalance());
        System.out.println(bankAccount);

    }

    private String accountNumber;
    private String ownerName;
    private double balance;

    public BankAccount(String accountNumber, String ownerName) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = 0;
    }

    public BankAccount() {
    }

    public void deposit(double amount) {
        balance += amount;
    }

    //TODO Subtracts the given amount from the account balance if there are sufficient funds.

    public void withdraw(double amount) {
       if (amount > balance) {
           System.out.println("Insufficient funds");
       }else{
           balance -= amount;
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