package com.zero.euler.part0001;

public final class A010SummationOfPrime {

    private A010SummationOfPrime() {
        throw new IllegalArgumentException();
    }

    public static long sumOfPrimeBelowTwoMillion() {
        long sum = 0;
        for (long number = 1; number < 2_000_000; number++) {
            if (A003LargestPrimeFactor.isPrimeNumber(number)) {
                sum += number;
            }
        }
        return sum;
    }
}
