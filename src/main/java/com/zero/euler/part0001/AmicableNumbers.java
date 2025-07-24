package com.zero.euler.part0001;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AmicableNumbers {

    public static void main(String[] args) {
        log.info("proper divisor 220 : {}", sumOfProperDivisor(220));

        log.info("is amicable number 220 : {}", isAmicableNumber(220));
        log.info("is amicable number 284 : {}", isAmicableNumber(284));

        log.info("amicable number below 10000 : {}", sumOfAmicableNumberBelow10000());
    }

    public static int sumOfAmicableNumberBelow10000() {
        int count = 0;
        for (int number = 1; number <= 10_000; number++) {
            if (isAmicableNumber(number)) {
                count += number;
            }
        }
        return count;
    }

    public static boolean isAmicableNumber(int a) {
        int b = sumOfProperDivisor(a);
        if (b == a) return false;
        return sumOfProperDivisor(b) == a;
    }

    public static int sumOfProperDivisor(int number) {
        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

}
