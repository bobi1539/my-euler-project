package com.zero.euler.level001;

public final class A10SummationOfPrime {

    private A10SummationOfPrime() {
        throw new IllegalArgumentException();
    }

    public static long sumOfPrimeBelowTwoMillion() {
        long sum = 0;
        for (long number = 1; number < 2_000_000; number++) {
            if (A03LargestPrimeFactor.isPrimeNumber(number)) {
                sum += number;
            }
        }
        return sum;
    }
}
