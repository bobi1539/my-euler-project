package com.zero.euler;

import com.zero.euler.part0001.A006SumSquareDifference;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class A006SumSquareDifferenceTest {

    @Test
    void testFindSumSquareDifferenceMathematics() {
        int sumSquareDifference = A006SumSquareDifference.findSumSquareDifferenceMathematics(10);
        assertEquals(2_640, sumSquareDifference);
        sumSquareDifference = A006SumSquareDifference.findSumSquareDifferenceMathematics(100);
        assertEquals(25_164_150, sumSquareDifference);
    }

    @Test
    void testFindSumSquareDifferenceManual() {
        int sumSquareDifference = A006SumSquareDifference.findSumSquareDifferenceManual(10);
        assertEquals(2_640, sumSquareDifference);
        sumSquareDifference = A006SumSquareDifference.findSumSquareDifferenceManual(100);
        assertEquals(25_164_150, sumSquareDifference);
    }
}