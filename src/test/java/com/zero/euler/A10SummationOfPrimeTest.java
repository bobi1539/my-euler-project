package com.zero.euler;

import com.zero.euler.level001.A10SummationOfPrime;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class A10SummationOfPrimeTest {

    @Test
    void testSumOfPrimeBelowTwoMillion() {
        long sum = A10SummationOfPrime.sumOfPrimeBelowTwoMillion();
        System.out.println("sum : " + sum);
        assertEquals(142_913_828_922L, sum);
    }
}