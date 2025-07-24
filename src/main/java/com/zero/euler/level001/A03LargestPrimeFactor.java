package com.zero.euler.level001;

public final class A03LargestPrimeFactor {

    private A03LargestPrimeFactor() {
        throw new IllegalArgumentException();
    }

    public static long findLargestPrimeFactor(long number) {
        long largestPrime = 0;
        for (long i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0 && isPrimeNumber(i)) largestPrime = i;
        }
        return largestPrime;
    }

    public static boolean isPrimeNumber(long number) {
        if (number <= 1) return false;
        for (long i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
