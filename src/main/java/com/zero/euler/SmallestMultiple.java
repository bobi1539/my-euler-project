package com.zero.euler;

public class SmallestMultiple {

    private SmallestMultiple() {
        throw new IllegalArgumentException();
    }

    public static int findSmallestNumberThatDividedFromOneToTwentyNoRemainder() {
        int smallestNumber;
        int number = 2;
        while (true) {
            boolean isNumberDividedFromOneToTwentyNoRemainder = true;
            for (int j = 1; j <= 20; j++) {
                if (number % j != 0) {
                    isNumberDividedFromOneToTwentyNoRemainder = false;
                    break;
                }
            }
            if (isNumberDividedFromOneToTwentyNoRemainder) {
                smallestNumber = number;
                break;
            }
            number += 2;
        }
        return smallestNumber;
    }
}
