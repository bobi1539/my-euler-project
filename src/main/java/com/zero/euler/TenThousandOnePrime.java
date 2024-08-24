package com.zero.euler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class TenThousandOnePrime {

    private TenThousandOnePrime() {
        throw new IllegalArgumentException();
    }

    public static long find10001PrimeNumber() {
        long counter = 0;
        long number = 1;
        long primeNumber;
        while (true) {
            if (LargestPrimeFactor.isPrimeNumber(number)) {
                counter += 1;
            }
            if (counter == 10001) {
                primeNumber = number;
                break;
            }
            number += 1;
        }
        return primeNumber;
    }

    public static int triplet() {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= 500; i++) {
            for (int j = 1; j <= 500; j++) {
                for (int k = 1; k <= 500; k++) {
                    int mi = (i * i);
                    int mj = (j * j);
                    int mk = (k * k);
                    int mij = mi + mj;
                    if (i + j + k == 1000 && mij == mk) {
                        set.add(i);
                        set.add(j);
                        set.add(k);
                    }
                }
            }
        }
        int product = 1;
        for (Integer s : set) {
            System.out.println(s);
            product *= s;
        }
        return product;
    }
}
