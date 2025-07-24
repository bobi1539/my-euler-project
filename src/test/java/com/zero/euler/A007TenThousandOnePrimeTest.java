package com.zero.euler;

import com.zero.euler.part0001.A007TenThousandOnePrime;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class A007TenThousandOnePrimeTest {

    @Test
    void testFind10001PrimeNumber() {
        long primeNumber = A007TenThousandOnePrime.find10001PrimeNumber();
        System.out.println(primeNumber);
        assertEquals(104_743, primeNumber);
    }

    @Test
    void testTriplet() {
        int triplet = A007TenThousandOnePrime.triplet();
        System.out.println(triplet);
    }
}