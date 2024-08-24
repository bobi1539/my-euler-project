package com.zero.euler;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SummationOfPrimeTest {

    @Test
    void testSumOfPrimeBelowTwoMillion() {
        long sum = SummationOfPrime.sumOfPrimeBelowTwoMillion();
        System.out.println("sum : " + sum);
        assertEquals(142_913_828_922L, sum);
    }
}