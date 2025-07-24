package com.zero.euler;

import com.zero.euler.level001.A07TenThousandOnePrime;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class A07TenThousandOnePrimeTest {

    @Test
    void testFind10001PrimeNumber() {
        long primeNumber = A07TenThousandOnePrime.find10001PrimeNumber();
        System.out.println(primeNumber);
        assertEquals(104_743, primeNumber);
    }

    @Test
    void testTriplet() {
        int triplet = A07TenThousandOnePrime.triplet();
        System.out.println(triplet);
    }
}