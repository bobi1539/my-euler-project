package com.zero.euler;

public final class SummationOfPrime {

    private SummationOfPrime() {
        throw new IllegalArgumentException();
    }

    public static long sumOfPrimeBelowTwoMillion() {
        long sum = 0;
        for (long number = 1; number < 2_000_000; number++) {
            if (LargestPrimeFactor.isPrimeNumber(number)) {
                sum += number;
            }
        }
        return sum;
    }
}
