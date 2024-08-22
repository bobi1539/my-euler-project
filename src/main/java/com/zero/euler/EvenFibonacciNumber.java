package com.zero.euler;

public final class EvenFibonacciNumber {

    private EvenFibonacciNumber() {
        throw new IllegalArgumentException();
    }

    public static int findSumOfEvenFibonacciNumber() {
        int sum = 0;
        int prev = 1;
        int next = 2;

        while (next < 4_000_000) {
            if (next % 2 == 0) {
                sum += next;
            }
            int temp = next;
            next = prev + next;
            prev = temp;
        }

        return sum;
    }
}
