package com.zero.euler.part0001;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class TriangleNumber {

    private TriangleNumber() {
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        int number = highlyDivisibleTriangularNumber();
        log.info("The first triangle number with more than 500 divisors is: {}", number);
    }

    public static int highlyDivisibleTriangularNumber() {
        int n = 1;
        while (true) {
            int a = n;
            int b = n + 1;

            // Bagi salah satu dengan 2 untuk hasil triangle number
            if (a % 2 == 0) a /= 2;
            else b /= 2;

            // hitung jumlah faktor dari a dan b
            int divisors = countDivisors(a) * countDivisors(b);
            if (divisors > 500) {
                return getTriangleNumber(n);
            }
            n++;
        }
    }

    public static int getTriangleNumber(int n) {
        return n * (n + 1) / 2;
    }

    public static int countDivisors(int number) {
        int count = 0;
        int sqrt = (int) Math.sqrt(number);
        for (int i = 1; i <= sqrt; i++) {
            if (number % i == 0) {
                count += 2; // i dan number/i
            }
        }
        if (sqrt * sqrt == number) {
            count--; // Koreksi jika perfect square
        }
        return count;
    }
}
