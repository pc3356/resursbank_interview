package com.resurs.interview.service;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;

@Service
public class CreditScoreService {

    private static final BigDecimal BALANCE_MULTIPLIER = BigDecimal.valueOf(0.5);
    private static final BigDecimal AVG_XACTION_VALUE_MULTIPLIER = BigDecimal.valueOf(0.3);
    private static final BigDecimal XACTION_COUNT_MULTIPLIER = BigDecimal.valueOf(0.2);

    public BigDecimal calculateCreditScore(final BigDecimal normalizedBalance, final BigDecimal averageTransactionAmount, final BigDecimal transactionCount) {


        return (normalizedBalance.multiply(BALANCE_MULTIPLIER)).add(
               (averageTransactionAmount.multiply(AVG_XACTION_VALUE_MULTIPLIER))).add(
               (transactionCount.multiply(XACTION_COUNT_MULTIPLIER)));
    }
}
