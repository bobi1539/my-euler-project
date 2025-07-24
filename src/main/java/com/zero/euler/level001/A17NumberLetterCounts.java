package com.zero.euler.level001;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class A17NumberLetterCounts {

    private static final Map<Integer, String> ones = Map.ofEntries(
            Map.entry(1, "one"), Map.entry(2, "two"), Map.entry(3, "three"),
            Map.entry(4, "four"), Map.entry(5, "five"), Map.entry(6, "six"),
            Map.entry(7, "seven"), Map.entry(8, "eight"), Map.entry(9, "nine"),
            Map.entry(10, "ten"), Map.entry(11, "eleven"), Map.entry(12, "twelve"),
            Map.entry(13, "thirteen"), Map.entry(14, "fourteen"), Map.entry(15, "fifteen"),
            Map.entry(16, "sixteen"), Map.entry(17, "seventeen"), Map.entry(18, "eighteen"),
            Map.entry(19, "nineteen")
    );

    private static final Map<Integer, String> tens = Map.ofEntries(
            Map.entry(20, "twenty"), Map.entry(30, "thirty"), Map.entry(40, "forty"),
            Map.entry(50, "fifty"), Map.entry(60, "sixty"), Map.entry(70, "seventy"),
            Map.entry(80, "eighty"), Map.entry(90, "ninety")
    );

    public static void main(String[] args) {
        int total = 0;

        for (int i = 1; i <= 1000; i++) {
            String word = numberToWords(i);
            word = word.replace(" ", "").replace("-", ""); // hilangkan spasi dan tanda hubung
            total += word.length();
        }

        log.info("Total letters used from 1 to 1000: {}", total);
    }

    private static String numberToWords(int n) {
        if (n == 1000) {
            return "one thousand";
        }

        StringBuilder word = new StringBuilder();

        if (n >= 100) {
            word.append(ones.get(n / 100)).append(" hundred");
            if (n % 100 != 0) {
                word.append(" and ");
            }
            n = n % 100;
        }

        if (n >= 20) {
            word.append(tens.get((n / 10) * 10));
            if (n % 10 != 0) {
                word.append("-").append(ones.get(n % 10));
            }
        } else if (n >= 1) {
            word.append(ones.get(n));
        }

        return word.toString();
    }
}
