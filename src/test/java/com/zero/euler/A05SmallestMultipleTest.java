package com.zero.euler;

import com.zero.euler.level001.A05SmallestMultiple;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class A05SmallestMultipleTest {

    @Test
    void testFindSmallestNumberThatDividedFromOneToTwentyNoRemainder() {
        long start = System.currentTimeMillis();
        int smallest = A05SmallestMultiple.findSmallestNumberThatDividedFromOneToTwentyNoRemainder();
        long end = System.currentTimeMillis();
        System.out.printf("%s : ms%n", end - start);
        System.out.println(smallest);

        assertEquals(232_792_560, smallest);
    }
}