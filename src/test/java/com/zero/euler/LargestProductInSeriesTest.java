package com.zero.euler;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargestProductInSeriesTest {

    @Test
    void testFindTheThirteenAdjacentDigits() {
        long result = LargestProductInSeries.findTheThirteenAdjacentDigits();
        System.out.println(result);
        assertEquals(23_514_624_000L, result);
    }
}