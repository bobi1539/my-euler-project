package com.zero.euler.part0001;

public final class A006SumSquareDifference {

    private A006SumSquareDifference() {
        throw new IllegalArgumentException();
    }

    public static int findSumSquareDifferenceMathematics(int n) {
        int sumOfSquare = n * (n + 1) * ((2 * n) + 1) / 6;
        int sum = n * (n + 1) / 2;
        int squareOfSum = sum * sum;
        return squareOfSum - sumOfSquare;
    }

    public static int findSumSquareDifferenceManual(int n) {
        int sumOfSquare = 0;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sumOfSquare += (i * i);
            sum += i;
        }
        return (sum * sum) - sumOfSquare;
    }
}
