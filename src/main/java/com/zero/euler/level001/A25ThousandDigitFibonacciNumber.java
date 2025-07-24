package com.zero.euler.level001;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;

@Slf4j
public class A25ThousandDigitFibonacciNumber {

    public static void main(String[] args) {
        log.info("index digit find 3 : {}", findIndexFibonacciDigit(3));
        log.info("");
        log.info("index digit find 10 : {}", findIndexFibonacciDigit(10));
        log.info("");
        log.info("index digit find 100 : {}", findIndexFibonacciDigit(100));
        log.info("");
        log.info("index digit find 1000 : {}", findIndexFibonacciDigit(1000));
        log.info("");
        log.info("index digit find 1000 : {}", findIndexFibonacciDigitFast(1000));
    }

    public static int findIndexFibonacciDigit(int digitFind) {
        BigInteger prev = BigInteger.ONE;
        BigInteger next = BigInteger.TWO;

        int index = 3;
        int digitLength = 0;
        while(digitLength != digitFind) {
            BigInteger temp = next;
            next = prev.add(next);
            prev = temp;

            digitLength = String.valueOf(next).length();
            index++;
        }

        log.info("digit length : {}", digitLength);
        log.info("next : {}", next);

        return index;
    }

    public static int findIndexFibonacciDigitFast(int digitFind) {
        double phi = (1 + Math.sqrt(5)) / 2;
        double log10Phi = Math.log10(phi);
        double log10Sqrt5 = Math.log10(Math.sqrt(5));

        return (int) Math.ceil((digitFind - 1 + log10Sqrt5) / log10Phi);
    }

}
