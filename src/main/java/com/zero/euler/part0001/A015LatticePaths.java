package com.zero.euler.part0001;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;

@Slf4j
public class A015LatticePaths {

    public static void main(String[] args) {
        log.info("grid 2 x 2 : {}", computeCombination(2));
        log.info("grid 3 x 3 : {}", computeCombination(3));
        log.info("grid 20 x 20 : {}", computeCombination(20));
        log.info("grid 20 x 20 : {}", optimizedCombination(20));
    }

    public static BigInteger computeCombination(int gridLength) {
        int pathLength = gridLength * 2;

        BigInteger nFactorial = A020FactorialDigitSum.computeFactorial(pathLength);
        BigInteger kFactorial = A020FactorialDigitSum.computeFactorial(gridLength);

        return nFactorial.divide(kFactorial.multiply(kFactorial));
    }

    public static BigInteger optimizedCombination(int n) {
        BigInteger numerator = BigInteger.ONE;
        BigInteger denominator = A020FactorialDigitSum.computeFactorial(n);

        for (int i = n + 1; i <= 2 * n; i++) {
            numerator = numerator.multiply(BigInteger.valueOf(i));
        }

        return numerator.divide(denominator);
    }

}
