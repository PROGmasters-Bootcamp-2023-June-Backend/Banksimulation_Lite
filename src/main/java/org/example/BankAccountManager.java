package org.example;

import java.util.ArrayList;
import java.util.List;

public class BankAccountManager {

    private List<BankAccount> accounts;


    public BankAccountManager() {
        this.accounts = new ArrayList<>();
    }

    public void createAccount(String ownerName, String accountNumber) {
        for (BankAccount bankAccount : accounts) {
            if (!bankAccount.getAccountNumber().equals(accountNumber)) {
                BankAccount bankAccountAdd = new BankAccount(accountNumber, ownerName);
                accounts.add(bankAccountAdd);
            } else {
                System.out.println("I already have such an account number!");

            }
        }
    }

    public BankAccount findAccount(String accountNumber) {
        for (BankAccount bankAccount : accounts) {
            if (bankAccount.getAccountNumber().equals(accountNumber)) {
                System.out.println(bankAccount);
                return bankAccount;
            }else{
            return null;
            }
        }
        return null;
    }

    public void deposit(String accountNumber, double amount){
        for (BankAccount bankAccount : accounts) {
            if (bankAccount.getAccountNumber().equals(accountNumber)) {
                bankAccount.deposit(amount);
            }else{

            }
        }
    }

    public String withdrawFromAccount(String accountNumber, double amount){
        for (BankAccount bankAccount : accounts) {
            if (bankAccount.getAccountNumber().equals(accountNumber)) {
                if(bankAccount.getBalance()>amount){
                    bankAccount.withdraw(amount);
                    return "Amount withdraw successfully";
                }else{
                    return "Account's balance too low!";
                }
            }
        }
        return "Account not found";
    }
    
    public double getAccountBalance(String accountNumber){
        for (BankAccount bankAccount : accounts) {
            if (bankAccount.getAccountNumber().equals(accountNumber)) {
                return bankAccount.getBalance();
            }
        }
        return -1;
        
    }

}
