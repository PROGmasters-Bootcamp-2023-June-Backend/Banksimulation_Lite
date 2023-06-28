package org.example;

import java.util.ArrayList;
import java.util.List;

public class BankAccountManager {
    public static void main(String[] args) {
        BankAccountManager bankAccountManager = new BankAccountManager();
        bankAccountManager.createAccount("John Doe","1");

        System.out.println(bankAccountManager);
        bankAccountManager.createAccount("John Doe","1");
        bankAccountManager.createAccount("John Doe","1");
        System.out.println(bankAccountManager);
        bankAccountManager.deposit("1",1000);
    }

    private List<BankAccount> accounts;

    public BankAccountManager() {
        this.accounts = new ArrayList<>();
    }

    public BankAccount findAccount(String findAccountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(findAccountNumber)) {
                return account;
            }
        }
        return null;

    }

    public void createAccount(String ownerName, String accountNumber) {
        BankAccount check = findAccount(accountNumber);
            if (check == null) {
                BankAccount account = new BankAccount(accountNumber,ownerName);
                accounts.add(account);
            }

    }


    @Override
    public String toString() {
        return "BankAccountManager{" +
                "accounts=" + accounts +
                '}';
    }

    public void deposit(String accountNumber, double amount) {
        BankAccount check = findAccount(accountNumber);
        if (check != null) {
            check.deposit(amount);
            System.out.println("OK");
        }else{
            System.out.println("NOK");
        }

    }

    public String withdrawFromAccount(String accountNumber,double amount) {
        BankAccount account = findAccount(accountNumber);
        String resultMessage = "Account not found";
        if (account != null) {
            boolean isWithdrawingPossible = account.getBalance() > 0 && account.getBalance() > amount;
            if (isWithdrawingPossible) {
                account.withdraw(amount);
                resultMessage = "Amount withdraw successfully";
            } else {
                resultMessage = "Account's balance too low!";
            }
        }
        return resultMessage;

    }

    public double getAccountBalance(String accountNumber) {
        BankAccount account = findAccount(accountNumber);
        if (account != null) {
            return account.getBalance();
        } else {
            return -1;
        }

    }


    public List<BankAccount> getAccounts() {
        return accounts;
    }

}
