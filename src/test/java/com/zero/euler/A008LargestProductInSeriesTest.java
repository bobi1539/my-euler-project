package com.zero.euler;

import com.zero.euler.part0001.A008LargestProductInSeries;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class A008LargestProductInSeriesTest {

    @Test
    void testFindTheThirteenAdjacentDigits() {
        long result = A008LargestProductInSeries.findTheThirteenAdjacentDigits();
        System.out.println(result);
        assertEquals(23_514_624_000L, result);
    }
}