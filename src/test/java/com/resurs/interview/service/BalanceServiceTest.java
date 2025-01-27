package com.resurs.interview.service;

import com.resurs.interview.entity.Transaction;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BalanceServiceTest {

    //@Autowired
    public BalanceService balanceService;

    @Test
    void getBalance() throws Exception {

        TransactionService transactionService = mock(TransactionService.class);
        balanceService = new BalanceService(transactionService);
        when(transactionService.getTransactionsByCustomerId(1L)).thenReturn(getMockTransactions());

        final double balance = balanceService.calculateBalance(1L);
        final double expectedBalance = 5165.33D;

        assertEquals(expectedBalance, balance);
    }

    private List<Transaction> getMockTransactions() {
        final Transaction t0 = new Transaction();
        t0.setAmount(55.43);
        final Transaction t1 = new Transaction();
        t1.setAmount(-24.99);
        final Transaction t2 = new Transaction();
        t2.setAmount(5164.86);
        final Transaction t3 = new Transaction();
        t3.setAmount(-12.99);
        final Transaction t4 = new Transaction();
        t4.setAmount(-16.98);
        return List.of(t0, t1, t2, t3, t4);
    }
}