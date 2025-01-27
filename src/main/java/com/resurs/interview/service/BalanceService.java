package com.resurs.interview.service;

import com.resurs.interview.entity.Transaction;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BalanceService {

    private final TransactionService transactionService;

    public double calculateBalance(final Long customerId) {

        final List<Transaction> transactions = transactionService.getTransactionsByCustomerId(customerId);

        double balance = 0D;

        for (final Transaction t : transactions) { // strongly ordered by xaction date!
            balance += t.getAmount();
        }

        return balance;
    }
}
