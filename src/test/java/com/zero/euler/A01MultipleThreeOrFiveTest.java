package com.zero.euler;

import com.zero.euler.part0001.A001MultipleThreeOrFive;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class A01MultipleThreeOrFiveTest {

    @Test
    void testMultiplesOfThreeOrFive() {
        int sum = A001MultipleThreeOrFive.multiplesOfThreeOrFive();
        assertEquals(233_168, sum);
    }
}