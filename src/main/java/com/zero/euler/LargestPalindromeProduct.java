package com.zero.euler;

public class LargestPalindromeProduct {

    private LargestPalindromeProduct() {
        throw new IllegalArgumentException();
    }

    public static int findLargestPalindromeProductThreeDigit() {
        int largestPalindromeProduct = 0;
        for (int i = 100; i < 1000; i++) {
            for (int j = i + 1; j < 1000; j++) {
                int m = i * j;
                boolean isPalindrome = isPalindrome(String.valueOf(m));
                if (isPalindrome && m > largestPalindromeProduct) {
                    largestPalindromeProduct = m;
                }

            }
        }
        return largestPalindromeProduct;
    }

    public static boolean isPalindrome(String value) {
        int left = 0;
        int right = value.length() - 1;

        while (left < right) {
            if (value.charAt(left) != value.charAt(right)) {
                return false;
            }
            left += 1;
            right -= 1;
        }
        return true;
    }
}
