package com.zero.euler;

import com.zero.euler.part0001.A003LargestPrimeFactor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargestPrimeFactorTest {

    @Test
    void testFindLargestPrimeFactor() {
        long number = 600851475143L;
        long largestPrimeFactor = A003LargestPrimeFactor.findLargestPrimeFactor(number);
        assertEquals(6857, largestPrimeFactor);
    }
}