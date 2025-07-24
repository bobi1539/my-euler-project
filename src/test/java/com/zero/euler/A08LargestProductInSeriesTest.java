package com.zero.euler;

import com.zero.euler.level001.A08LargestProductInSeries;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class A08LargestProductInSeriesTest {

    @Test
    void testFindTheThirteenAdjacentDigits() {
        long result = A08LargestProductInSeries.findTheThirteenAdjacentDigits();
        System.out.println(result);
        assertEquals(23_514_624_000L, result);
    }
}