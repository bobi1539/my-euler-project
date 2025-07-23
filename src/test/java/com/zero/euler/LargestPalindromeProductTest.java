package com.zero.euler;

import com.zero.euler.part0001.LargestPalindromeProduct;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargestPalindromeProductTest {

    @Test
    void testFindLargestPalindromeProductThreeDigit() {
        int largestPalindromeProductThreeDigit = LargestPalindromeProduct.findLargestPalindromeProductThreeDigit();
        System.out.println(largestPalindromeProductThreeDigit);
        assertEquals(906_609, largestPalindromeProductThreeDigit);
    }
}