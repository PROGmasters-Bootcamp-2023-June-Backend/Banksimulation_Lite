package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BankAccountManager {
    private List<BankAccount> accounts = new ArrayList<>();



    public BankAccountManager() {

    }

    public BankAccount findAccount(String accountNumber) {


        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }

        return null;
    }

    public void createAccount(String ownerName, String accountNumber) {
        System.out.println(accounts);
        if (findAccount(accountNumber) != null) {
            System.out.println("Ez az számlaszám már foglalt");
        } else {
            BankAccount bankAccount = new BankAccount(ownerName, accountNumber);
            accounts.add(bankAccount);
        }
    }

    public void deposit(String accountNumber, double amount) {
        BankAccount bankAccount2 = findAccount(accountNumber);

        if (bankAccount2 == null) {
            throw new NullPointerException("Nincs ilyen bankfiók");
        }
        bankAccount2.deposit(amount);
    }

    public String withdrawFromAccount(String accountNumber, double amount) {

        BankAccount bankAccount2 = findAccount(accountNumber);

        if (bankAccount2 == null) {
            throw new NullPointerException("Account not found.");
        }
        bankAccount2.withdraw(amount);

        return "Amount withdraw succesfully";
    }

    public double getAccountBalance(String accountNumber) {
        BankAccount bankAccount2 = findAccount(accountNumber);

        if (bankAccount2 == null) {
            return -1;
        }
      return  bankAccount2.getBalance();

    }
    public List<BankAccount> getAccounts() {
        return accounts;
    }

}
