package com.zero.euler;

import com.zero.euler.part0001.A004LargestPalindromeProduct;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class A004LargestPalindromeProductTest {

    @Test
    void testFindLargestPalindromeProductThreeDigit() {
        int largestPalindromeProductThreeDigit = A004LargestPalindromeProduct.findLargestPalindromeProductThreeDigit();
        System.out.println(largestPalindromeProductThreeDigit);
        assertEquals(906_609, largestPalindromeProductThreeDigit);
    }
}