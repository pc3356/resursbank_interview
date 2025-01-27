package com.resurs.interview.service;

import java.math.BigDecimal;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class CreditScoreServiceTest {

//    @Autowired
    public CreditScoreService creditScoreService;

    @ParameterizedTest
    @MethodSource("scoreValues")
    void scores(final BigDecimal normalizedBalance, final BigDecimal averageTransactionAmount, final BigDecimal transactionCount, final BigDecimal expectedScore) {

        creditScoreService = new CreditScoreService();
        final BigDecimal score = creditScoreService.calculateCreditScore(normalizedBalance, averageTransactionAmount, transactionCount);
        assertEquals(expectedScore, score);
    }

    private static Stream<Arguments> scoreValues() {
        return Stream.of(
                Arguments.of(BigDecimal.valueOf(0), BigDecimal.valueOf(0), BigDecimal.valueOf(0), BigDecimal.valueOf(0.0)),
                Arguments.of(BigDecimal.valueOf(-1), BigDecimal.valueOf(-1), BigDecimal.valueOf(1), BigDecimal.valueOf(-0.6)),
                Arguments.of(BigDecimal.valueOf(1), BigDecimal.valueOf(1), BigDecimal.valueOf(1), BigDecimal.valueOf(1.0)),
                Arguments.of(BigDecimal.valueOf(2), BigDecimal.valueOf(2), BigDecimal.valueOf(2), BigDecimal.valueOf(2.0)),
                Arguments.of(BigDecimal.valueOf(100), BigDecimal.valueOf(10), BigDecimal.valueOf(10), BigDecimal.valueOf(55.0))
        );
    }
}