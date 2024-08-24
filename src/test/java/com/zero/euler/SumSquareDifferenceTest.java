package com.zero.euler;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumSquareDifferenceTest {

    @Test
    void testFindSumSquareDifferenceMathematics() {
        int sumSquareDifference = SumSquareDifference.findSumSquareDifferenceMathematics(10);
        assertEquals(2_640, sumSquareDifference);
        sumSquareDifference = SumSquareDifference.findSumSquareDifferenceMathematics(100);
        assertEquals(25_164_150, sumSquareDifference);
    }

    @Test
    void testFindSumSquareDifferenceManual() {
        int sumSquareDifference = SumSquareDifference.findSumSquareDifferenceManual(10);
        assertEquals(2_640, sumSquareDifference);
        sumSquareDifference = SumSquareDifference.findSumSquareDifferenceManual(100);
        assertEquals(25_164_150, sumSquareDifference);
    }
}