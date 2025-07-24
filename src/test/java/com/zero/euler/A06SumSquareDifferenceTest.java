package com.zero.euler;

import com.zero.euler.level001.A06SumSquareDifference;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class A06SumSquareDifferenceTest {

    @Test
    void testFindSumSquareDifferenceMathematics() {
        int sumSquareDifference = A06SumSquareDifference.findSumSquareDifferenceMathematics(10);
        assertEquals(2_640, sumSquareDifference);
        sumSquareDifference = A06SumSquareDifference.findSumSquareDifferenceMathematics(100);
        assertEquals(25_164_150, sumSquareDifference);
    }

    @Test
    void testFindSumSquareDifferenceManual() {
        int sumSquareDifference = A06SumSquareDifference.findSumSquareDifferenceManual(10);
        assertEquals(2_640, sumSquareDifference);
        sumSquareDifference = A06SumSquareDifference.findSumSquareDifferenceManual(100);
        assertEquals(25_164_150, sumSquareDifference);
    }
}