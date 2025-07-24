package com.zero.euler;

import com.zero.euler.part0001.A010SummationOfPrime;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class A010SummationOfPrimeTest {

    @Test
    void testSumOfPrimeBelowTwoMillion() {
        long sum = A010SummationOfPrime.sumOfPrimeBelowTwoMillion();
        System.out.println("sum : " + sum);
        assertEquals(142_913_828_922L, sum);
    }
}