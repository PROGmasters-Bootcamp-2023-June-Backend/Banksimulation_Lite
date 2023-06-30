package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankAccountManager {
    private List<BankAccount> accounts;

    public BankAccountManager() {
        this.accounts = new ArrayList<>();
    }

    public BankAccount findAccount(String accountNumber) {
            for (BankAccount account : accounts) {
                if (account.getAccountNumber().equals(accountNumber)) {
                    return account;
                }
            }
        return null;
    }

    //    findAccount(number)
    public void createAccount(String name, String number) {

        BankAccount bankAccount = findAccount(number);
        if (bankAccount == null){
            BankAccount account = new BankAccount(name,number);
            accounts.add(account);
            System.out.println("Created an account.");
        }
    }

    public void deposit(String accountNumber, double amount) {
        BankAccount bankAccountFound = findAccount(accountNumber);
        if (bankAccountFound != null) {
            bankAccountFound.deposit(amount);
        }
    }

    public String withdrawFromAccount(String accountNumber, double amount) {
        String text;
        BankAccount bankAccount = findAccount(accountNumber);
        if (bankAccount != null) {
            bankAccount.withdraw(amount);
            text = "Amount withdraw successfully";
        } else {
            text = "Account not found";
        }
        if (bankAccount.getBalance() < 0 || bankAccount.getBalance() < amount){
            text = "Account's balance too low!";
        }
        return text;
    }
    public  double getAccountBalance (String accountNumber){
        double number = 0;
        BankAccount accountBalance = findAccount(accountNumber);
        if (accountBalance != null) {
            if (accountBalance.getBalance() > 0) {
                number = accountBalance.getBalance();
            }
        } else {
            number = -1;
        }
        return number;
    }

    public List getAccounts() {
        return accounts;
    }
}
