package com.zero.euler.level001;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;

@Slf4j
public class A16PowerDigitSum {

    public static void main(String[] args) {

        BigInteger twoPowerThousand = BigInteger.TWO;

        for (int i = 1; i < 1_000; i++) {
            twoPowerThousand = twoPowerThousand.multiply(BigInteger.TWO);
        }

        log.info("2 power 1000 : {}", twoPowerThousand);

        int sumOfDigitOfTwoPowerThousand = 0;
        for (char c : twoPowerThousand.toString().toCharArray()) {
            sumOfDigitOfTwoPowerThousand += Integer.parseInt(String.valueOf(c));
        }

        log.info("Sum of digit of two power thousand : {}", sumOfDigitOfTwoPowerThousand);
    }

}
