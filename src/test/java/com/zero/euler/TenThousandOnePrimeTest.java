package com.zero.euler;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TenThousandOnePrimeTest {

    @Test
    void testFind10001PrimeNumber() {
        long primeNumber = TenThousandOnePrime.find10001PrimeNumber();
        System.out.println(primeNumber);
        assertEquals(104_743, primeNumber);
    }

    @Test
    void testTriplet() {
        int triplet = TenThousandOnePrime.triplet();
        System.out.println(triplet);
    }
}