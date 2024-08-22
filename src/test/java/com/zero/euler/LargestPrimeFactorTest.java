package com.zero.euler;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargestPrimeFactorTest {

    @Test
    void testFindLargestPrimeFactor() {
        long number = 600851475143L;
        long largestPrimeFactor = LargestPrimeFactor.findLargestPrimeFactor(number);
        assertEquals(6857, largestPrimeFactor);
    }
}