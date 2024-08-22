package com.zero.euler;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EvenFibonacciNumberTest {

    @Test
    void testFindSumOfEvenFibonacciNumber() {
        int sum = EvenFibonacciNumber.findSumOfEvenFibonacciNumber();
        assertEquals(4_613_732, sum);
    }
}