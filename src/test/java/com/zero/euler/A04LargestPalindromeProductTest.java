package com.zero.euler;

import com.zero.euler.level001.A04LargestPalindromeProduct;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class A04LargestPalindromeProductTest {

    @Test
    void testFindLargestPalindromeProductThreeDigit() {
        int largestPalindromeProductThreeDigit = A04LargestPalindromeProduct.findLargestPalindromeProductThreeDigit();
        System.out.println(largestPalindromeProductThreeDigit);
        assertEquals(906_609, largestPalindromeProductThreeDigit);
    }
}