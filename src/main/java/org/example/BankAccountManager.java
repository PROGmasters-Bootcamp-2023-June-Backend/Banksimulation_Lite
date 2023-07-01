package org.example;

import java.util.ArrayList;
import java.util.List;

public class BankAccountManager {
    public static void main(String[] args) {

        BankAccountManager manager = new BankAccountManager();
        manager.createAccount("John Doe", "1");
        System.out.println(manager.findAccount("1").getOwnerName());
        manager.findAccount("1").deposit(1000);
        System.out.println(manager.findAccount("1").getBalance());
    }

    private List<BankAccount> accounts;

    public BankAccountManager() {
        this.accounts = new ArrayList<>();
    }

    public BankAccount findAccount( String accountNumber ) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
           return null;
    }

    public void createAccount( String ownerName, String accountNumber) {
            BankAccount checked = findAccount(accountNumber);
            if (checked == null) {
                BankAccount bankAccount = new BankAccount(accountNumber,ownerName);
                accounts.add(bankAccount);
            }else {
                System.out.println("Warning message createAccount");
            }
    }

    public void deposit( String accountNumber, double amount ) {
            BankAccount checked = findAccount(accountNumber);
            if (checked != null) {
                checked.deposit(amount);
            }
    }

    public String withdrawFromAccount(String accountNumber, double amount) {
        BankAccount checked = findAccount(accountNumber);
        if (checked != null) {
            return checked.withdraw(amount);
        }
        return "Account not found";
    }

    public double getAccountBalance(String accountNumber) {
        BankAccount checked = findAccount(accountNumber);
        if (checked != null) {
            return checked.getBalance();
        }
        return -1;
    }


    public List<BankAccount> getAccounts() {
        return accounts;
    }

    @Override
    public String toString() {
        return "BankAccountManager{" +
                "accounts=" + accounts +
                '}';
    }

}
