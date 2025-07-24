package com.zero.euler;

import com.zero.euler.level001.A01MultipleThreeOrFive;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class A01MultipleThreeOrFiveTest {

    @Test
    void testMultiplesOfThreeOrFive() {
        int sum = A01MultipleThreeOrFive.multiplesOfThreeOrFive();
        assertEquals(233_168, sum);
    }
}