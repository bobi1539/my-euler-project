package com.zero.euler;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SmallestMultipleTest {

    @Test
    void testFindSmallestNumberThatDividedFromOneToTwentyNoRemainder() {
        long start = System.currentTimeMillis();
        int smallest = SmallestMultiple.findSmallestNumberThatDividedFromOneToTwentyNoRemainder();
        long end = System.currentTimeMillis();
        System.out.printf("%s : ms%n", end - start);
        System.out.println(smallest);

        assertEquals(232_792_560, smallest);
    }
}