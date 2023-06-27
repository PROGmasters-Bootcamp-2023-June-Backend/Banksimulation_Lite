package org.example;

import java.util.ArrayList;
import java.util.List;

public class BankAccountManager {

    private List<BankAccount> accounts;
    private boolean readyAccount = false;


    public BankAccountManager() {
        this.accounts = new ArrayList<>();
    }

    public void createAccount(String ownerName, String accountNumber) {
        findAccount(accountNumber);
        if(!readyAccount){
        BankAccount bankAccountAdd = new BankAccount(accountNumber, ownerName);
        accounts.add(bankAccountAdd);
        }

    }

    public boolean findAccount(String accountNumber) {
        for (BankAccount bankAccount : accounts) {
            if (bankAccount.getAccountNumber().equals(accountNumber)) {
                readyAccount = true;
                return readyAccount;
            }
        }
        readyAccount = false;
        return readyAccount;
    }

    public void deposit(String accountNumber, double amount) {
        for (BankAccount bankAccount : accounts) {
            if (bankAccount.getAccountNumber().equals(accountNumber)) {
                bankAccount.deposit(amount);
            }
        }
    }

    public String withdrawFromAccount(String accountNumber, double amount) {
        for (BankAccount bankAccount : accounts) {
            if (bankAccount.getAccountNumber().equals(accountNumber)) {
                if (bankAccount.getBalance() > amount) {
                    bankAccount.withdraw(amount);
                    return "Amount withdraw successfully";
                } else {
                    return "Account's balance too low!";
                }
            }
        }
        return "Account not found";
    }

    public double getAccountBalance(String accountNumber) {
        for (BankAccount bankAccount : accounts) {
            if (bankAccount.getAccountNumber().equals(accountNumber)) {
                return bankAccount.getBalance();
            }
        }
        return -1;

    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }
}
