package com.javaplayground;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {
    
    private BankAccount account;
    
    @BeforeEach
    void setUp() {
        account = new BankAccount("12345", 1000.0);
    }
    
    @Test
    @DisplayName("Initial balance should be set correctly")
    void testConstructor() {
        assertEquals("12345", account.getAccountNumber());
        assertEquals(1000.0, account.getBalance(), 0.01);
    }
    
    @Test
    @DisplayName("Deposit should increase balance")
    void testDeposit() {
        account.deposit(500.0);
        assertEquals(1500.0, account.getBalance(), 0.01);
    }
    
    @Test
    @DisplayName("Withdraw should decrease balance")
    void testWithdraw() {
        account.withdraw(200.0);
        assertEquals(800.0, account.getBalance(), 0.01);
    }
    
    @Test
    @DisplayName("Cannot withdraw more than balance")
    void testWithdrawInsufficientFunds() {
        assertThrows(IllegalArgumentException.class, () ->
                account.withdraw(1500.0)
        );
        assertEquals(1000.0, account.getBalance(), 0.01); // Balance unchanged
    }
    
    @Test
    @DisplayName("Cannot deposit negative amount")
    void testDepositNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-100.0);
        });
        assertEquals(1000.0, account.getBalance(), 0.01);
    }
    
    @Test
    @DisplayName("Cannot create account with negative initial balance")
    void testConstructorNegativeBalance() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BankAccount("99999", -100.0);
        });
    }
}
