package com.zero.euler;

import com.zero.euler.level001.A02EvenFibonacciNumber;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class A02EvenFibonacciNumberTest {

    @Test
    void testFindSumOfEvenFibonacciNumber() {
        int sum = A02EvenFibonacciNumber.findSumOfEvenFibonacciNumber();
        assertEquals(4_613_732, sum);
    }

    @Test
    void test() {
        String result = mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"});
        assertEquals("ball", result);

        result = mostCommonWord("a.", new String[]{});
        assertEquals("a", result);

        result = mostCommonWord("a, a, a, a, b,b,b,c, c", new String[]{"a"});
        assertEquals("b", result);
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.toLowerCase().split("\\W+");

        Set<String> ban = new HashSet<>(Arrays.asList(banned));

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (!ban.contains(word)) {
                map.merge(word, 1, Integer::sum);
            }
        }

        int max = 0;
        String result = "";
        for (String key : map.keySet()) {
            Integer count = map.get(key);
            if (count > max) {
                max = count;
                result = key;
            }
        }

        return result;
    }
}