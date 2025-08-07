package com.zero.euler.level002;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public class A26ReciprocalCycles {

    public static void main(String[] args) {
        log.info("number max repeat : {}", findNumberMaximumReciprocalCycles());
        log.info("");
        log.info("number max repeat : {}", findNumberMaximumReciprocalCyclesRobust());
    }

    public static int findNumberMaximumReciprocalCyclesRobust() {
        int maxCycleLength = 0;
        int numberWithMaxCycle = 0;

        for (int d = 2; d <= 1000; d++) {
            if (gcd(d, 10) != 1) continue; // skip terminable decimals

            Set<Integer> seenRemainders = new HashSet<>();
            int remainder = 1;
            int cycleLength = 0;

            while (!seenRemainders.contains(remainder)) {
                seenRemainders.add(remainder);
                remainder = (remainder * 10) % d;
                cycleLength++;
            }

            if (cycleLength > maxCycleLength) {
                maxCycleLength = cycleLength;
                numberWithMaxCycle = d;
            }
        }

        log.info("max cycle length: {}", maxCycleLength);
        return numberWithMaxCycle;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static int findNumberMaximumReciprocalCycles() {
        int maxRepeat = 0;
        int numberMaxRepeat = 0;
        for (int d = 2; d <= 1_000; d++) {
            if (d % 2 == 0 || d % 5 == 0) continue;

            int firstRemaining = 1;
            int repeat = 0;
            while (true) {
                int remaining = firstRemaining * 10 % d;
                firstRemaining = remaining;
                repeat += 1;

                if (remaining == 1) break;
            }
            if (repeat > maxRepeat) {
                maxRepeat = repeat;
                numberMaxRepeat = d;
            }
        }
        log.info("max repeat : {}", maxRepeat);
        return numberMaxRepeat;
    }


}
