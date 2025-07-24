package com.zero.euler.part0001;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
public class NonAbundantSums {

    public static void main(String[] args) {
        log.info("is abundant number 28 : {}", isAbundantNumber(28));
        log.info("is abundant number 12 : {}", isAbundantNumber(12));
        log.info("abundant number from 1 to 28123 : {}", findAbundantNumber().size());
        log.info("sum of number not from sum of abundant number : {}", calculateSumOfNumberNotFromSumOfAbundantNumber());
    }

    /**
     * Menghitung jumlah dari semua bilangan positif ≤ 28.123 yang
     * TIDAK dapat ditulis sebagai jumlah dari dua bilangan abundant.
     * <p>
     * Algoritma:
     * 1. Cari semua bilangan abundant dari 1 hingga 28.123:
     * - Untuk setiap bilangan n dari 1 sampai 28.123:
     * - Hitung jumlah semua pembagi sebenarnya dari n (bilangan lebih kecil dari n yang habis membagi n)
     * - Jika jumlah pembagi lebih besar dari n, maka n adalah bilangan abundant
     * - Simpan semua bilangan abundant ke dalam daftar abundantList
     * - Buat juga abundantSet dari daftar tersebut untuk pencarian cepat
     * <p>
     * 2. Inisialisasi total jumlah sum dengan nilai 0
     * <p>
     * 3. Untuk setiap bilangan number dari 1 hingga 28.123:
     * - Asumsikan number tidak dapat dibentuk dari dua bilangan abundant
     * - Untuk setiap bilangan a dalam abundantList:
     * - Hitung b = number - a
     * - Jika b ada dalam abundantSet:
     * - Tandai bahwa number bisa ditulis sebagai jumlah dua bilangan abundant
     * - Berhenti mencari pasangan
     * - Jika tidak ditemukan pasangan:
     * - Tambahkan number ke dalam total sum
     * <p>
     * 4. Setelah selesai memeriksa semua bilangan, kembalikan nilai sum
     *
     * @return jumlah dari semua bilangan ≤ 28.123 yang tidak bisa ditulis
     * sebagai jumlah dua bilangan abundant
     */
    public static int calculateSumOfNumberNotFromSumOfAbundantNumber() {
        int sum = 0;
        List<Integer> abundantList = new ArrayList<>(findAbundantNumber());
        Set<Integer> abundantSet = new HashSet<>(abundantList);
        for (int number = 1; number <= 28_123; number++) {
            boolean canBeWritten = false;
            for (int a : abundantList) {
                int b = number - a;
                if (abundantSet.contains(b)) {
                    canBeWritten = true;
                    break;
                }
            }
            if (!canBeWritten) {
                sum += number;
            }
        }
        return sum;
    }

    public static List<Integer> findAbundantNumber() {
        List<Integer> abundantNumbers = new ArrayList<>();
        for (int number = 1; number <= 28_123; number++) {
            if (isAbundantNumber(number)) abundantNumbers.add(number);
        }
        return abundantNumbers;
    }

    public static boolean isAbundantNumber(int number) {
        int sumOfProperDivisor = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) sumOfProperDivisor += i;
        }
        return sumOfProperDivisor > number;
    }

}
