package com.zero.euler.part0001;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LongestCollatzSequence {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        long longestChain = 0;
        long numberThatHaveLongestChain = 0;
        for (long i = 1; i < 1_000_000; i++) {
            long chain = countChain(i);
            if (chain > longestChain) {
                longestChain = chain;
                numberThatHaveLongestChain = i;
            }
        }

        long end = System.currentTimeMillis();
        log.info("Duration : {}ms", end - start);

        log.info("Longest chain : {}", longestChain);
        log.info("The number : {}", numberThatHaveLongestChain);


    }

    public static long countChain(long number) {
        long chain = 0;
        while(number > 1) {
            if (number % 2 == 0) {
                number /= 2;
            } else {
                number = (3 * number) + 1;
            }
            chain += 1;
        }
        return chain + 1;
    }

}
