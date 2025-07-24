package com.zero.euler.level001;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;

@Slf4j
public class A20FactorialDigitSum {

    public static void main(String[] args) {
        log.info("100! : {}", calculate(100));
    }

    public static int calculate(int value) {
        BigInteger factorial = computeFactorial(value);
        return sumDigits(factorial);
    }

    public static BigInteger computeFactorial(int value) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= value; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static int sumDigits(BigInteger value) {
        int sum = 0;
        for (char digit : value.toString().toCharArray()) {
            sum += digit - '0';
        }
        return sum;
    }

}
