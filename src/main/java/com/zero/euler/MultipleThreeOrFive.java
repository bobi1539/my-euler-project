package com.zero.euler;

public final class MultipleThreeOrFive {

    private MultipleThreeOrFive() {
        throw new IllegalArgumentException();
    }

    public static int multiplesOfThreeOrFive() {
        int sum = 0;
        for (int number = 1; number < 1000; number++) {
            if (number % 3 == 0 || number % 5 == 0) {
                sum += number;
            }
        }
        return sum;
    }
}
