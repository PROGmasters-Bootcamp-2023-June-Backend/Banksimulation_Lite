package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccountManager manager;

    @BeforeEach
    public void setUp() {
        manager = new BankAccountManager();
    }

    @Test
    void testCreateAccount() {
        manager.createAccount("John Doe", "1");
        assertEquals(1, manager.getAccounts().size());
    }

    @Test
    void testDeposit() {
        manager.createAccount("John Doe", "1");
        manager.deposit("1", 1000.0);
        assertEquals(1000.0, manager.getAccountBalance("1"));
    }

    @Test
    void testWithdrawSufficientFunds() {
        manager.createAccount("John Doe", "1");
        manager.deposit("1", 1000.0);
        manager.withdrawFromAccount("1", 500.0);
        assertEquals(500.0, manager.getAccountBalance("1"));
    }

    @Test
    void testWithdrawInsufficientFunds() {
        manager.createAccount("John Doe", "1");
        manager.deposit("1", 1000.0);
        String actual = manager.withdrawFromAccount("1", 500.0);
        String excepted = "Amount withdraw successfully";
        assertEquals(excepted, actual);
    }

    @Test
    void testWithdrawBalanceTooLow() {
        manager.createAccount("John Doe", "1");
        manager.deposit("1", 1000.0);
        String actual = manager.withdrawFromAccount("1", 1500.0);
        String excepted = "Account's balance too low!";
        assertEquals(excepted, actual);
    }

    @Test
    void testWithdrawAccountNotFound() {
        String actual = manager.withdrawFromAccount("1", 1500.0);
        String excepted = "Account not found";
        assertEquals(excepted, actual);
    }

    @Test
    void testGetAccountBalance() {
        manager.createAccount("John Doe", "1");
        manager.deposit("1", 1000.0);
        assertEquals(1000.0, manager.getAccountBalance("1"));
    }

    @Test
    void testGetAccountBalanceIfAccountNotExist() {
        manager.deposit("1", 1000.0);
        assertEquals(-1, manager.getAccountBalance("1"));
    }

}