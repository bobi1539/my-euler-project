package com.zero.euler;

import com.zero.euler.part0001.MultipleThreeOrFive;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MultipleThreeOrFiveTest {

    @Test
    void testMultiplesOfThreeOrFive() {
        int sum = MultipleThreeOrFive.multiplesOfThreeOrFive();
        assertEquals(233_168, sum);
    }
}